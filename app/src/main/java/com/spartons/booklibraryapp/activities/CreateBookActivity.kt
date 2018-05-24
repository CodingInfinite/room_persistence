package com.spartons.booklibraryapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.spartons.booklibraryapp.R
import com.spartons.booklibraryapp.adapters.CustomSpinnerAdapter
import com.spartons.booklibraryapp.data.AuthorModel
import com.spartons.booklibraryapp.data.BookItem
import com.spartons.booklibraryapp.repository.AuthorRepository
import com.spartons.booklibraryapp.repository.BookRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_create_book.*
import javax.inject.Inject


class CreateBookActivity : BaseActivity() {

    companion object {
        fun getCreateBookActivity(@NonNull callingClassContext: Context) = Intent(callingClassContext, CreateBookActivity::class.java)
    }

    @Inject
    lateinit var authorRepository: AuthorRepository
    @Inject
    lateinit var bookRepository: BookRepository

    private var selectAuthorModel: AuthorModel? = null
    private var authorNameArray: MutableList<AuthorModel> = mutableListOf()
    private lateinit var authorAdapter: ArrayAdapter<AuthorModel>

    private val itemSelectedListener: AdapterView.OnItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {

        }

        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            selectAuthorModel = authorNameArray[p2]
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_book)
        setAuthorAdapter()
        getComponent().inject(this)
        authorRepository
                .getAllAuthors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    authorNameArray.addAll(it)
                    authorAdapter.notifyDataSetChanged()
                }, { it.printStackTrace() })
        newAuthorButton.setOnClickListener {
            showAddAuthorDialog {
                val author = AuthorModel(authorName = it)
                authorRepository.insert(author)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            authorNameArray.add(author)
                            authorAdapter.notifyDataSetChanged()
                        }, { it.printStackTrace() })
            }
        }
        authorSpinner.onItemSelectedListener = itemSelectedListener
        addBookButton.setOnClickListener {
            if (selectAuthorModel == null) {
                Toast.makeText(this, "Please first add author", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (!bookNameEditText.text.toString().isEmpty())
                bookRepository.insert(BookItem(authorId = selectAuthorModel!!.authorId, name = bookNameEditText.text.toString(), authorName = selectAuthorModel!!.authorName))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            Toast.makeText(this, "Book inserted", Toast.LENGTH_SHORT).show()
                        }, { it.printStackTrace() })
            else
                Toast.makeText(this, "Book name cannot be empty", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAuthorAdapter() {
        authorAdapter = CustomSpinnerAdapter(this, android.R.layout.simple_spinner_item, authorNameArray)
        authorSpinner.adapter = authorAdapter
    }

    private fun showAddAuthorDialog(closure: (String) -> Unit) {
        MaterialDialog.Builder(this)
                .title("Add Author")
                .input("Author Name", "", false) { _, input ->
                    closure(input.toString())
                }
                .cancelable(false)
                .positiveText("Add")
                .negativeText("Cancel")
                .onNegative({ dialog, _ -> dialog.dismiss() })
                .show()
    }
}

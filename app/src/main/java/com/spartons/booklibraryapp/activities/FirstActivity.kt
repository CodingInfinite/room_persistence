package com.spartons.booklibraryapp.activities

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.spartons.booklibraryapp.R
import com.spartons.booklibraryapp.adapters.BooksAdapter
import com.spartons.booklibraryapp.data.AuthorModel
import com.spartons.booklibraryapp.data.BookItem
import com.spartons.booklibraryapp.repository.AuthorRepository
import com.spartons.booklibraryapp.repository.BookRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_first.*
import javax.inject.Inject

class FirstActivity : BaseActivity() {

    @Inject
    lateinit var bookRepository: BookRepository
    @Inject
    lateinit var authorRepository: AuthorRepository

    private lateinit var bookAdapter: BooksAdapter
    private val booksList: MutableList<BookItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        getComponent().inject(this)
        setBookAdapter()
        insertBookFloatButton.setOnClickListener {
            startActivity(CreateBookActivity.getCreateBookActivity(this))
        }
    }

    override fun onResume() {
        super.onResume()
        bookRepository
                .getAllBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it.isEmpty())
                        noBookTextView.visibility = View.VISIBLE
                    else
                        noBookTextView.visibility = View.GONE
                    booksList.clear()
                    bookAdapter.notifyDataSetChanged()
                    booksList.addAll(it)
                    bookAdapter.notifyDataSetChanged()
                }, { it.printStackTrace() })
    }

    private fun setBookAdapter() {
        bookRecyclerView.layoutManager = LinearLayoutManager(this)
        bookRecyclerView.setHasFixedSize(true)
        bookAdapter = BooksAdapter(this, booksList)
        bookRecyclerView.adapter = bookAdapter
    }


    private fun hello() {
        authorRepository.insert(AuthorModel(authorName = "Ahsen Saeed"))
    }


}

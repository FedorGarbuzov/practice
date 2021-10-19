package ru.surf.practice

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import rx.Observable
import rx.Subscriber

class MainActivity : AppCompatActivity() {

    private val activityLauncher = registerForActivityResult(SecondActivityContract()) { result ->
        Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stringList = listOf(
            "Come with me if you want to live",
            "Hasta la vista, baby",
            "I’ll be back",
            "I need your clothes, your boots and your motorcycle",
            "I know now why you cry but it’s something I can never do",
        )

        val button: Button = findViewById(R.id.to_act_two_btn)
        val rv: RecyclerView = findViewById(R.id.rv)

        rv.adapter = StringListAdapter(stringList)

        button.setOnClickListener {
            activityLauncher.launch("I’ll be back")
        }
        getProductsById()
    }

    data class Product(
        val id: Int,
        val categoryId: Int,
        val name: String
    )

    data class Category(
        val id: Int,
        val name: String,
        val subCategory: List<SubCategory>
    ) {
        data class SubCategory(
            val id: Int,
            val categoryId: Int,
            val name: String
        )
    }


    val pork = Product(
        1,
        1,
        "Pork"
    )

    val chicken = Product(
        2,
        1,
        "Chicken"
    )

    val beef = Product(
        3,
        1,
        "Beef"
    )

    val gouda = Product(
        4,
        1,
        "Gouda"
    )

    val parmesan = Product(
        5,
        1,
        "Parmesan"
    )

    val hat = Product(
        6,
        2,
        "Hat"
    )

    val jacket = Product(
        7,
        2,
        "Jacket"
    )

    val pants = Product(
        8,
        2,
        "Pants"
    )
    val socks = Product(
        9,
        2,
        "Socks"
    )


    val meatSubCategory = Category.SubCategory(
        1,
        1,
        "Meat"
    )

    val cheeseSubCategory = Category.SubCategory(
        2,
        1,
        "Cheese"
    )

    val outerwearSubCategory = Category.SubCategory(
        3,
        2,
        "Outerwear"
    )

    val lingerieSubCategory = Category.SubCategory(
        4,
        2,
        "Lingerie"
    )

    val foodCategory = Category(
        1,
        "Food",
        listOf(meatSubCategory, cheeseSubCategory)
    )

    val wearCategory = Category(
        2,
        "Wear",
        listOf(outerwearSubCategory, lingerieSubCategory)
    )

    val products = Observable.just(pork, chicken, beef, gouda, parmesan, hat, jacket, pants, socks)
    val productCategories = Observable.just(foodCategory, wearCategory)

    fun getProductsById() {

        val categoryId = 1

        val ids = productCategories.filter {
            it.id == categoryId
        }.map { category ->
            category.subCategory.map {
                it.categoryId
            }
        }


        val products = ids.map { list ->
            list.map { id ->
                products.filter { product ->
                    product.id == id
                }
            }
        }
    }
}
package com.aymen.instantnews.data.entities

class Specification {
    var category: String? = null
        private set

    // Default country
    var country = "fr"

    var language: String? = null

    fun setCategory(category: Category) {
        this.category = category.name
    }
}

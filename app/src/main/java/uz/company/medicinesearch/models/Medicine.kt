package uz.company.medicinesearch.models

data class Medicine(
        val id: Int,
        val name: String,
        val description: String,
        val isFavorite: Boolean,
        val price: Int
)
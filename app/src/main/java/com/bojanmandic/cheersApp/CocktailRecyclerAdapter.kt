package com.bojanmandic.cheersApp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CocktailRecyclerAdapter(private val items: CocktailList): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        return CocktailViewHolder(

            LayoutInflater.from(parent.context).inflate(R.layout.cocktail_layout, parent,
                false)
        )
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder,
                                  position: Int) {
        val item = items.drinks[position]
        when(holder) {
            is CocktailViewHolder -> {
                holder.bind(items.drinks[position])
                holder.itemView.setOnClickListener {
                    val intent = Intent(holder.itemView.context, CocktailActivity::class.java)
                    intent.putExtra("name", item.strDrink)
                    intent.putExtra("type", "${item.strAlcoholic}, ${item.strCategory}")

                    var ingredients = ""
                    if (item.strIngredient1 != null) ingredients += item.strMeasure1 + " " + item.strIngredient1 + ", "
                    if (item.strIngredient2 != null) ingredients += item.strMeasure2 + " " + item.strIngredient2 + ", "
                    if (item.strIngredient3 != null) ingredients += item.strMeasure3 + " " + item.strIngredient3 + ", "
                    if (item.strIngredient4 != null) ingredients += item.strMeasure4 + " " + item.strIngredient4 + ", "
                    if (item.strIngredient5 != null) ingredients += item.strMeasure5 + " " + item.strIngredient5 + ", "
                    if (item.strIngredient6 != null) ingredients += item.strMeasure6 + " " + item.strIngredient6 + ", "
                    if (item.strIngredient7 != null) ingredients += item.strMeasure7 + " " + item.strIngredient7 + ", "
                    if (item.strIngredient8 != null) ingredients += item.strMeasure8 + " " + item.strIngredient8 + ", "
                    if (item.strIngredient9 != null) ingredients += item.strMeasure9 + " " + item.strIngredient9 + ", "
                    if (item.strIngredient10 != null) ingredients += item.strMeasure10 + " " + item.strIngredient10 + ", "
                    if (item.strIngredient11 != null) ingredients += item.strMeasure11 + " " + item.strIngredient11 + ", "
                    if (item.strIngredient12 != null) ingredients += item.strMeasure12 + " " + item.strIngredient12 + ", "
                    if (item.strIngredient13 != null) ingredients += item.strMeasure13 + " " + item.strIngredient13 + ", "
                    if (item.strIngredient14 != null) ingredients += item.strMeasure14 + " " + item.strIngredient14 + ", "
                    if (item.strIngredient15 != null) ingredients += item.strMeasure15 + " " + item.strIngredient15 + ", "

                    intent.putExtra("ingredients", ingredients.dropLast(2))
                    intent.putExtra("instructions", item.strInstructions)
                    intent.putExtra("image", item.strDrinkThumb)

                    holder.itemView.context.startActivity(intent)
                }
            }
        }
    }
    override fun getItemCount(): Int {
        return items.drinks.size
    }

    class CocktailViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        private val cocktailPhoto: ImageView =
            itemView.findViewById(R.id.cocktailImage)
        private val cocktailName: TextView =
            itemView.findViewById(R.id.cocktailName)
        private val cocktailType: TextView =
            itemView.findViewById(R.id.cocktailType)
        private val cocktailIngredience: TextView =
            itemView.findViewById(R.id.cocktailIngredience)
        private val cocktailInstructions: TextView =
            itemView.findViewById(R.id.cocktailInstructions)
        fun bind(cocktail: Cocktail) {
            Glide
                .with(itemView.context)
                .load(cocktail.strDrinkThumb)
                .into(cocktailPhoto)
            cocktailName.text = cocktail.strDrink
            cocktailType.text = "${cocktail.strAlcoholic}, ${cocktail.strCategory}"
            var ingredients = ""
            if (cocktail.strIngredient1 != null) ingredients += cocktail.strMeasure1 + " " + cocktail.strIngredient1 + ", "
            if (cocktail.strIngredient2 != null) ingredients += cocktail.strMeasure2 + " " + cocktail.strIngredient2 + ", "
            if (cocktail.strIngredient3 != null) ingredients += cocktail.strMeasure3 + " " + cocktail.strIngredient3 + ", "
            if (cocktail.strIngredient4 != null) ingredients += cocktail.strMeasure4 + " " + cocktail.strIngredient4 + ", "
            if (cocktail.strIngredient5 != null) ingredients += cocktail.strMeasure5 + " " + cocktail.strIngredient5 + ", "
            if (cocktail.strIngredient6 != null) ingredients += cocktail.strMeasure6 + " " + cocktail.strIngredient6 + ", "
            if (cocktail.strIngredient7 != null) ingredients += cocktail.strMeasure7 + " " + cocktail.strIngredient7 + ", "
            if (cocktail.strIngredient8 != null) ingredients += cocktail.strMeasure8 + " " + cocktail.strIngredient8 + ", "
            if (cocktail.strIngredient9 != null) ingredients += cocktail.strMeasure9 + " " + cocktail.strIngredient9 + ", "
            if (cocktail.strIngredient10 != null) ingredients += cocktail.strMeasure10 + " " + cocktail.strIngredient10 + ", "
            if (cocktail.strIngredient11 != null) ingredients += cocktail.strMeasure11 + " " + cocktail.strIngredient11 + ", "
            if (cocktail.strIngredient12 != null) ingredients += cocktail.strMeasure12 + " " + cocktail.strIngredient12 + ", "
            if (cocktail.strIngredient13 != null) ingredients += cocktail.strMeasure13 + " " + cocktail.strIngredient13 + ", "
            if (cocktail.strIngredient14 != null) ingredients += cocktail.strMeasure14 + " " + cocktail.strIngredient14 + ", "
            if (cocktail.strIngredient15 != null) ingredients += cocktail.strMeasure15 + " " + cocktail.strIngredient15 + ", "

            cocktailIngredience.text = ingredients.dropLast(2)
            cocktailInstructions.text = cocktail.strInstructions
        }
    }
}
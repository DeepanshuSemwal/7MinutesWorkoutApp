package com.example.a7minworkout

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minworkout.databinding.ExcercisestatusBinding


class ExerciseStatusAdapter(val items:ArrayList<ExcerciseModel>):RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {

    class ViewHolder(binding: ExcercisestatusBinding):RecyclerView.ViewHolder(binding.root)
    {
        val tvItem=binding.tvItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ExcercisestatusBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model: ExcerciseModel=items[position]
        holder.tvItem.text=model.getId().toString()
        when{
            model.getIssletected() ->{
                holder.tvItem.background=ContextCompat.getDrawable(holder.itemView.context,R.drawable.circular_thin_color_bg_border)
                holder.tvItem.setTextColor(Color.parseColor( "#212121"))


            }

            model.getIscompleted() -> {
                holder.tvItem.background=ContextCompat.getDrawable(holder.itemView.context,R.drawable.circular_progressbar_background)
                holder.tvItem.setTextColor(Color.parseColor( "#FFFFFF"))

            }

            else ->{
                holder.tvItem.background=ContextCompat.getDrawable(holder.itemView.context,R.drawable.item_circular_shape)
                holder.tvItem.setTextColor(Color.parseColor( "#212121"))

            }
        }

    }

    override fun getItemCount(): Int {

        return items.size
    }


}
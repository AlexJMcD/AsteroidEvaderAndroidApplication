package com.amcd.unity.lib.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amcd.unity.R
import com.amcd.unity.databinding.ScoreListItemBinding
import com.amcd.unity.lib.db.HighScore
import java.time.LocalDateTime

class ScoreTableAdapter(private val scoreList: List<HighScore>) :
    RecyclerView.Adapter<ScoreTableAdapter.ScoreViewHolder>() {

    inner class ScoreViewHolder(val binding: ScoreListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val binding =
            ScoreListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScoreViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return scoreList.size
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        holder.apply {
            scoreList[position].apply {
                val resources = holder.itemView.context.resources
                binding.scoreDate.text = LocalDateTime.parse(this.dateAchieved).toLocalDate().toString()
                val rank = (position + 1).toString()
                binding.rank.text = rank
                binding.scoreValue.text = this.highScore.toString()
                binding.rankContainer.setBackgroundColor(
                    when (position) {
                        0 -> resources.getColor(R.color.app_gold, null)
                        1 -> resources.getColor(R.color.app_silver, null)
                        2 -> resources.getColor(R.color.app_bronze, null)
                        else -> resources.getColor(R.color.black, null)
                    }
                )
            }
        }
    }
}
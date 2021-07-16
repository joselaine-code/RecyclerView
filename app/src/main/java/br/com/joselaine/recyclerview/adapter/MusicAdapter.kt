package br.com.joselaine.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.joselaine.recyclerview.databinding.MusicItemBinding
import br.com.joselaine.recyclerview.model.Music

class MusicAdapter(
    private val listMusic: List<Music>,
    private val onClickListener: (music: Music) -> Unit
) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding = MusicItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicViewHolder(binding)
    }

    //Essa parte do código que efetiva os dados da lista dentro do View Holder (XML)
    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(listMusic[position], onClickListener)
    }

    override fun getItemCount() = listMusic.size

    inner class MusicViewHolder(private val binding: MusicItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            music: Music,
            onClickListener: (music: Music) -> Unit
        ) {
            binding.nameMusic.text = music.name
            binding.nameArtist.text = music.artist
            binding.vgMusicItemContainer.setOnClickListener {
                onClickListener(music)
            }
        }

    }

}
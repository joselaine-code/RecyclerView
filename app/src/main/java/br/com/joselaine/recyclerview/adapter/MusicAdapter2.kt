package br.com.joselaine.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.joselaine.recyclerview.databinding.MusicItem2Binding
import br.com.joselaine.recyclerview.databinding.MusicItemBinding
import br.com.joselaine.recyclerview.model.Music
import br.com.joselaine.recyclerview.utils.OnClickListenerMusic

//Adapter com dois modelos de visualização

class MusicAdapter2(
    private val musicList: List<Music>,
    private val onClickListenerMusic: OnClickListenerMusic,
    private val onClickListener: (music: Music) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_DEFAULT) {
            val binding = MusicItemBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolder(binding)
        } else {
            val binding = MusicItem2Binding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolderBlack(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(musicList[position], onClickListenerMusic)
        } else if (holder is ViewHolderBlack) {
            holder.bind(musicList[position], onClickListener)
        }
    }

    override fun getItemCount() = musicList.size

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            VIEW_TYPE_BLACK
        } else {
            VIEW_TYPE_DEFAULT
        }
    }

    class ViewHolder(
        val binding: MusicItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            music: Music,
            onClickListenerMusic: OnClickListenerMusic,
        ) {
            binding.nameMusic.text = music.name
            binding.nameArtist.text = music.artist
            binding.vgMusicItemContainer.setOnClickListener {
                onClickListenerMusic.onClickListener(music)
            }
        }
    }

    class ViewHolderBlack(
        val binding: MusicItem2Binding
    ) : RecyclerView.ViewHolder(binding.root) {

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

    companion object {
        const val VIEW_TYPE_DEFAULT = 1
        const val VIEW_TYPE_BLACK = 2
    }
}
package br.com.joselaine.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.joselaine.recyclerview.adapter.MusicAdapter
import br.com.joselaine.recyclerview.adapter.MusicAdapter2
import br.com.joselaine.recyclerview.databinding.FragmentMusicasBinding
import br.com.joselaine.recyclerview.model.Music
import br.com.joselaine.recyclerview.utils.OnClickListenerMusic

class MusicasFragment : Fragment(), OnClickListenerMusic {

    private var binding: FragmentMusicasBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMusicasBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val music1 = Music(
            "Love of my life",
            "Queen"
        )
        val music2 = Music(
            "Sabão Crá Crá",
            "Mamonas Assassinas"
        )
        val music3 = Music(
            "Evidências",
            "Chitãozinho e Xororó"
        )
        val music4 = Music(
            "Amarelo",
            "Emicida"
        )
        val music5 = Music(
            "Boa esperança",
            "Emicida"
        )
        val music6 = Music(
            "Esquema Preferido",
            "Barões da Pisadinha"
        )
        val musica7 = Music(
            "A Lua",
            "Pabllo Vittar"
        )
        val music8 = Music(
            "Volta comigo, bebê",
            "Zé Vaqueiro"
        )
        val music9 = Music(
            "Linda demais",
            "Roupa Nova"
        )
        val musicList = listOf(music1, music2, music3, music4, music5, music6, musica7, music8, music9)

        //Adapter com uma visualização
        val musicAdapter = MusicAdapter(musicList) {
            Toast.makeText(context, "${it.name} - ${it.artist}", Toast.LENGTH_SHORT).show()
        }

        //Adapter com dois tipos de views
        val musicAdapter2 = MusicAdapter2(musicList, this) {
            Toast.makeText(context, "${it.name} - ${it.artist}", Toast.LENGTH_SHORT).show()
        }

        binding?.let {
            with(it) {
                binding?.vgMusicsRecyclerView?.layoutManager = LinearLayoutManager(context)
                binding?.vgMusicsRecyclerView?.adapter = musicAdapter2
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onClickListener(music: Music) {
        Toast.makeText(context, "${music.name} - ${music.artist}", Toast.LENGTH_SHORT).show()
    }
}
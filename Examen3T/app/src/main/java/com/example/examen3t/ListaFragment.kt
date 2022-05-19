package com.example.examen3t


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.examen3t.databinding.FragmentListaBinding


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ListaFragment : Fragment() {

    private var _binding: FragmentListaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listadoRock:MutableList<Album> = ArrayList()
        listadoRock.add(Album("Abbey Road", "The Beatles", R.drawable.abbeyroad, resources.getString(R.string.abbeyroad)))
        listadoRock.add(Album("Exile on Main Street", "The Rolling Stones", R.drawable.exileonmainst, resources.getString(R.string.exilesonmainstreet)))
        listadoRock.add(Album("The Velvet Underground", "The Velvet Underground and Nico", R.drawable.velvetunderground, resources.getString(R.string.velvetunderground)))
        listadoRock.add(Album("Are You Experienced", "Jimi Hendrix", R.drawable.areyouexperienced, resources.getString(R.string.areyouexperienced)))
        listadoRock.add(Album("Back in Black", "AC/DC", R.drawable.backinblack, resources.getString(R.string.backinblack)))
        listadoRock.add(Album("Appetite for Destruction", "Guns N’ Roses", R.drawable.appetitefordestruction, resources.getString(R.string.appetitefordestruction)))
        listadoRock.add(Album("Led Zeppelin IV", "Led Zeppelin", R.drawable.ledzeppeliniv, resources.getString(R.string.ledzeppeliniv)))


        val listadoBlues:MutableList<Album> = ArrayList()
        listadoBlues.add(Album("Lady Soul", "Aretha Franklin", R.drawable.ladysoul, resources.getString(R.string.ladysoul)))
        listadoBlues.add(Album("I Never Loved a Man the Way I Love You", "Aretha Franklin", R.drawable.neverloved, resources.getString(R.string.ineverloveda)))
        listadoBlues.add(Album("What's Going On", "Marvin Gaye", R.drawable.whatsgoingon, resources.getString(R.string.whatsgoingon)))


        val listadoJazz:MutableList<Album> = ArrayList()
        listadoJazz.add(Album("Kind of Blue", "Miles Davis", R.drawable.kindofblue, resources.getString(R.string.kindofblue)))
        listadoJazz.add(Album("Bitches Brew", "Miles Davis", R.drawable.bitchesbrew, resources.getString(R.string.bitchesbrew)))
        listadoJazz.add(Album("A Love Supreme", "John Coltrane", R.drawable.alovesupreme, resources.getString(R.string.alovesupreme)))

        val listadoDiscos:MutableList<Album> = ArrayList()

        var genero = ListaFragmentArgs.fromBundle(requireArguments()).genero

        when(genero){
            "rock" ->listadoDiscos.addAll(listadoRock)
            "blues" ->listadoDiscos.addAll(listadoBlues)
            "jazz" -> listadoDiscos.addAll(listadoJazz)
            "varios" -> { listadoDiscos.addAll(listadoRock)
                        listadoDiscos.addAll(listadoBlues)
                        listadoDiscos.addAll(listadoJazz)}
        }


        binding.recyclerView
            .apply{adapter= CustomAadapter(listadoDiscos)}

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



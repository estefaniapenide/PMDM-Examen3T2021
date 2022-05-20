package com.example.examen3tfinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import com.example.examen3tfinal.databinding.FragmentCompuestaBinding

class CompuestaFragment : Fragment() {

    private var _binding: FragmentCompuestaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCompuestaBinding.inflate(inflater, container, false)
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
        listadoJazz.add(Album("Kind of Blue", "Miles Davis",R.drawable.kindofblue, resources.getString(R.string.kindofblue)))
        listadoJazz.add(Album("Bitches Brew", "Miles Davis", R.drawable.bitchesbrew, resources.getString(R.string.bitchesbrew)))
        listadoJazz.add(Album("A Love Supreme", "John Coltrane", R.drawable.alovesupreme, resources.getString(R.string.alovesupreme)))

        val listadoDiscos:MutableList<Album> = ArrayList()


        /*fun onCheckboxClicked(view: View) {
            if (view is CheckBox) {
                val checked: Boolean = view.isChecked

                when (view.id) {
                    R.id.checkbox_meat -> {
                        if (checked) {
                            // Put some meat on the sandwich
                        } else {
                            // Remove the meat
                        }
                    }
                    R.id.checkbox_cheese -> {
                        if (checked) {
                            // Cheese me
                        } else {
                            // I'm lactose intolerant
                        }
                    }
                    // TODO: Veggie sandwich
                }
            }
        }*/

        fun onCheckboxClicked(view: View) {
            if (view is CheckBox) {
                val checked: Boolean = view.isChecked

                when (view.id) {
                    R.id.cbRock -> {
                        if (checked) {
                            listadoDiscos.addAll(listadoRock)
                            binding.textviewFirst.visibility=View.GONE
                            binding.recyclerViewSimple
                                .apply{visibility=View.VISIBLE}
                                .apply{adapter=CustomAdapter(listadoDiscos)}
                            // Put some meat on the sandwich
                        } else {
                            listadoDiscos.removeAll(listadoRock)
                             //si listdoRock está vacío: hacer el reycler view invisible
                            // Remove the meat
                        }
                    }
                    R.id.checkbox_cheese -> {
                        if (checked) {
                            // Cheese me
                        } else {
                            // I'm lactose intolerant
                        }
                    }
                    // TODO: Veggie sandwich
                }
            }
        }

        binding.cbRock.setOnClickListener{
            binding.textviewFirst.visibility=View.GONE
            binding.recyclerViewSimple
                .apply{visibility=View.VISIBLE}
                .apply{adapter=CustomAdapter(listadoRock)}
        }

        binding.cbBlues.setOnClickListener{
            binding.textviewFirst.visibility=View.GONE
            binding.recyclerViewSimple
                .apply{visibility=View.VISIBLE}
                .apply{adapter=CustomAdapter(listadoBlues)}
        }

        binding.cbJazz.setOnClickListener{
            binding.textviewFirst.visibility=View.GONE
            binding.recyclerViewSimple
                .apply{visibility=View.VISIBLE}
                .apply{adapter=CustomAdapter(listadoJazz)}
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
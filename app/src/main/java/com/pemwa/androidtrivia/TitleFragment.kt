package com.pemwa.androidtrivia


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.pemwa.androidtrivia.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class TitleFragment : Fragment() {

    private lateinit var binding: FragmentTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_title, container, false)

        //Telling Android that our TitleFragment has a menu
        setHasOptionsMenu(true)

        play()
        return binding.root
    }

    //Inflating our new menu resource using the provided menu inflater and menu structure
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    //Connecting onOptionsItemSelected to our NavigationUI
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item,
            view!!.findNavController()) || super.onOptionsItemSelected(item)
    }

    private fun play() {
        //Setting the action onClickListener with Navigation
        binding.playButton.setOnClickListener {
//            // Using ID to navigate to the GameFragment
//            it.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)

            // Using directions to navigate to the GameFragment
            it.findNavController().navigate(
                TitleFragmentDirections.actionTitleFragmentToGameFragment()
            )
        }

//        //Setting the action onClickListener with Navigation using createNavigateOnClickListener
//        binding.playButton.setOnClickListener(
//            Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment))
    }


}

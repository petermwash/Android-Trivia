package com.pemwa.androidtrivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.pemwa.androidtrivia.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Inflating the layout for this fragment here
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_over, container, false
        )
        binding.tryAgainButton.setOnClickListener {
//            // Using ID to navigate to the GameFragment
//            it.findNavController().navigate(R.id.action_gameOverFragment_to_gameFragment)

            // Using directions to navigate to the GameFragment
            it.findNavController().navigate(
                GameOverFragmentDirections.actionGameOverFragmentToGameFragment()
            )
        }
        return binding.root
    }
}
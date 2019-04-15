package com.pemwa.androidtrivia

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.pemwa.androidtrivia.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment(){

    private lateinit var binding: FragmentGameWonBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Inflating the layout for this fragment here
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false
        )
        playAgain()
        setHasOptionsMenu(true)

        return binding.root
    }

    private fun playAgain() {
        binding.nextMatchButton.setOnClickListener {
            //            // Using ID to navigate to the GameFragment
//            it.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)

            // Using directions to navigate to the GameFragment
            it.findNavController().navigate(
                GameWonFragmentDirections.actionGameWonFragmentToGameFragment()
            )
        }
    }



    /**
     * Creating our Share Intent
     */
    private fun shareResults() {
        startActivity(getShareIntent())
    }

    private fun getShareIntent(): Intent {
        val args = arguments?.let {
            GameWonFragmentArgs.fromBundle(it)
        }
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(
                R.string.share_success_text, args?.numCorrect, args?.numQuestions
            ))
        return shareIntent
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.winner_menu, menu)

        // check if the activity resolves
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu.findItem(R.id.share)?.setVisible(false)
        }
    }

    // Sharing from the Menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.share -> shareResults()
        }
        return super.onOptionsItemSelected(item)
    }
}
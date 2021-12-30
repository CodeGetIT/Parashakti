package com.parashakti.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.parashakti.R
import com.parashakti.databinding.FragmentGalleryBinding
import com.parashakti.others.MyPreferences
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {

    private lateinit var galleryViewModel: GalleryViewModel
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    lateinit var myPreferences: MyPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        myPreferences = MyPreferences(root.context)

        val textView: TextView = binding.tvName
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = myPreferences.user_name
        })
        val tvMobile: TextView = binding.tvMobile
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            tvMobile.text = myPreferences.mobile
        })

        val tvEmail: TextView = binding.tvEmail
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            tvEmail.text = myPreferences.email
        })


        val tvAgentCode: TextView = binding.tvAgentCode
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            tvAgentCode.text = myPreferences.agentcode
        })


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.ibrahimethem.cryptoblogmain.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.ibrahimethem.cryptoblogmain.R
import com.ibrahimethem.cryptoblogmain.ViewModelFactory
import com.ibrahimethem.cryptoblogmain.databinding.FragmentHomeBinding
import com.ibrahimethem.cryptoblogmain.network.CryptoService
import com.ibrahimethem.cryptoblogmain.network.RetrofitHelper
import com.ibrahimethem.cryptoblogmain.repo.CryptoRepo


class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel : HomeViewModel by viewModels {
        ViewModelFactory(
            CryptoRepo(RetrofitHelper.getInstance().create(CryptoService::class.java))
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getCryptoAll()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cAdapter = CryptoListAdapter{}
        binding.cryptoListRc.adapter = cAdapter
        viewModel.cryptoList.observe(viewLifecycleOwner){items ->
           items?.data?.let {
               binding.errorMessage.isVisible = false
               binding.cryptoListRc.isVisible = true
               cAdapter.submitList(it)
           }
        }
        viewModel.cryptoError.observe(viewLifecycleOwner){error ->
            error?.let {
                binding.errorMessage.isVisible = true
                binding.cryptoListRc.isVisible = false
                binding.errorMessage.text = it
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //memory leak önlemek için
        _binding = null
    }
}
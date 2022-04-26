package com.example.android3_1_github.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.android3_1_github.R
import com.example.android3_1_github.app
import com.example.android3_1_github.databinding.MainFragmentBinding
import com.example.android3_1_github.domain.entity.User
import com.example.android3_1_github.ui.details.DetailsFragment

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels { MainViewModelFactory(requireActivity().app.gitHubUser) }

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private var adapter: MainFragmentAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.users.observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getUsersFromServer()
    }

    private fun renderData(it: List<User>) {
        adapter = MainFragmentAdapter(
            object : OnItemViewClickListener {
                override fun onItemViewClick(user: User) {
                    val managerFr = activity?.supportFragmentManager
                    managerFr?.let {
                        val bundle = Bundle().apply {
                            putParcelable(DetailsFragment.BUNDLE_REPO, user)
                        }
                        managerFr.beginTransaction()
                            .replace(R.id.container, DetailsFragment.newInstance(bundle))
                            .addToBackStack("")
                            .commitAllowingStateLoss()
                    }
                }
            }
        ).apply { setData(it) }
        binding.mainFragmentRv.adapter = adapter
    }


    interface OnItemViewClickListener {
        fun onItemViewClick(user: User)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
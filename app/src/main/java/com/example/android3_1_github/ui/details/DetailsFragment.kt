package com.example.android3_1_github.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.example.android3_1_github.app
import com.example.android3_1_github.databinding.DetailsFragmentBinding
import com.example.android3_1_github.domain.entity.Repo
import com.example.android3_1_github.domain.entity.User

class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModels { DetailsViewModelFactory(requireActivity().app.gitHubRepo) }

    private var _binding: DetailsFragmentBinding? = null
    private val binding get() = _binding!!

    private var adapter: DetailsFragmentAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<User>(BUNDLE_REPO)?.let {
            viewModel.repos.observe(viewLifecycleOwner, { renderData(it) })
            viewModel.getRepoFromServer(it.login)
            binding.itemLoginTv.text = it.login
            binding.itemIdTv.text = it.id.toString()
            binding.itemAvatar.load(it.avatarUrl)
        }
    }

    private fun renderData(it: List<Repo>) = with(binding) {
        adapter = DetailsFragmentAdapter()
        adapter?.setRepos(it)
        binding.detailsFragmentRv.adapter = adapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val BUNDLE_REPO = "repo"
        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}
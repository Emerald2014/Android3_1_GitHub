package com.example.android3_1_github.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android3_1_github.R
import com.example.android3_1_github.data.User
import com.example.android3_1_github.databinding.MainFragmentBinding
import com.example.android3_1_github.ui.details.DetailsFragment

class MainFragment : Fragment() {

    private var viewModel: MainViewModel = MainViewModel()

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

    val data = arrayListOf(
        User(1, "login1", "null", "null"),
        User(2, "login2", "null", "null"),
        User(3, "login3", "null", "null"),
        User(4, "login4", "null", "null")
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it) })
        viewModel.getUsersFromServer()
    }

    private fun renderData(it: GitHubState<User>) {
        if (it is GitHubState.Success) {
            adapter = MainFragmentAdapter(
                object :OnItemViewClickListener {
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
            ).apply { setData(it.serverResponseData) }

            binding.mainFragmentRv.adapter = adapter
        }

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
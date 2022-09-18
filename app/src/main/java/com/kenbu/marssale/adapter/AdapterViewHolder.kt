package com.kenbu.marssale.adapter


import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kenbu.marssale.databinding.ItemLayoutBinding
import com.kenbu.marssale.model.RealEstateModel
import com.kenbu.marssale.view.CatalogFragmentDirections

class AdapterViewHolder(private val estateDataBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(estateDataBinding.root) {
    /**
     * View Holder that Change Instances
     *
     * @param estateModel
     */
    fun onBind(estateModel: RealEstateModel) {
        val binding = estateDataBinding as ItemLayoutBinding

        if (estateModel.type == "buy") {
            estateModel.type = "For Sale"
        } else {
            estateModel.type = "For Rent"
        }
        binding.apply {
            //Setting Layout Binding Adapter
            setVariable(BR.estateList, estateModel)
            //Navigation From Catalog to Clicked Image View
            itemView.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(
                        CatalogFragmentDirections.actionCatalogFragmentToDetailFragment(
                            estateModel
                        )
                    )
            }
        }
    }
}
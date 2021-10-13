/*
package fastcampus.aop.part5.chapter04.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.afinal.databinding.ViewholderGalleryPhotoItemBinding
import fastcampus.aop.part5.chapter04.databinding.ViewholderPhotoItemBinding
import fastcampus.aop.part5.chapter04.extensions.loadCenterCrop

class PhotoListAdapter(
    private val removePhotoListener: (Uri) -> Unit
) : RecyclerView.Adapter<PhotoListAdapter.ProductItemViewHolder>() {

    private var imageUriList: List<Uri> = listOf()

    inner class ProductItemViewHolder(
        private val binding: ViewholderGalleryPhotoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

      */
/*  fun bindData(data: Uri) = with(binding) {
            binding.photoImageView.loadCenterCrop(data.toString(), 8f)
        }*//*


        fun bindViews(data: Uri) = with(binding) {
            checkButton.setOnClickListener {
                removePhotoListener(data)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemViewHolder {
        val view = ViewholderGalleryPhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductItemViewHolder, position: Int) {
        //holder.bindData(imageUriList[position])
        holder.bindViews(imageUriList[position])
    }

    override fun getItemCount(): Int = imageUriList.size

    fun setPhotoList(imageUriList: List<Uri>) {
        this.imageUriList = imageUriList
        notifyDataSetChanged()
    }
}
*/


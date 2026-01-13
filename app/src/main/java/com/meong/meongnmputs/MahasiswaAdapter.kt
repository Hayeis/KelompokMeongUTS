package com.meong.meongnmputs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meong.meongnmputs.databinding.MhsCardBinding

class MahasiswaAdapter(private val onItemClick: (Mahasiswa) -> Unit): RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>()
    {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MahasiswaViewHolder {
        val binding = MhsCardBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return MahasiswaViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: MahasiswaViewHolder,
        position: Int
    ) {
        holder.binding.imgMhs.setImageResource(UserData.dataMahasiswa[position].imageId)
        holder.binding.txtNamaMhs.text = UserData.dataMahasiswa[position].nama
        holder.binding.txtDetailMhs.text = "NRP :\t" + UserData.dataMahasiswa[position].nrp + "\nPRODI :\t" +
                UserData.dataMahasiswa[position].prodi

        val mahasiswanya = UserData.dataMahasiswa[position]
        holder.binding.root.setOnClickListener {
            onItemClick(mahasiswanya)
        }

    }
    override fun getItemCount(): Int {
        return UserData.dataMahasiswa.size
    }

    class MahasiswaViewHolder(val binding:
                              MhsCardBinding): RecyclerView.ViewHolder(binding.root)
}
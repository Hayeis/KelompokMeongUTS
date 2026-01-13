package com.meong.meongnmputs

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyFriendListsAdapter(
    private val data: ArrayList<Mahasiswa>
) : RecyclerView.Adapter<MyFriendListsAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val imgFoto: ImageView = v.findViewById(R.id.imgFoto)
        val txtNama: TextView = v.findViewById(R.id.txtName)
        val txtNrp: TextView = v.findViewById(R.id.txtNrp)
        val txtProdi: TextView = v.findViewById(R.id.txtProdi)
        val btnEmail: ImageView = v.findViewById(R.id.btnEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.myfriends_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mhs = data[position]
        holder.txtNama.text = mhs.nama
        holder.txtNrp.text = mhs.nrp
        holder.txtProdi.text = mhs.prodi
        Picasso.get()
            .load(mhs.photoUrl)
            .into(holder.imgFoto)

        holder.itemView.setOnClickListener(null)

        holder.btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(
                Intent.EXTRA_TEXT,
                "Halo " + mhs.nama + ", salam kenal!"
            )

            holder.itemView.context.startActivity(
                Intent.createChooser(intent, "Send Email")
            )
        }
    }
    override fun getItemCount(): Int {
        return data.size
    }
}

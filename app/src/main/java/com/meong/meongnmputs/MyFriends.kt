package com.meong.meongnmputs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MyFriendsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyFriendListsAdapter
    private val listFriends = ArrayList<Mahasiswa>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_my_friends, container, false)

        recyclerView = view.findViewById(R.id.recyclerMyFriends)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = MyFriendListsAdapter(listFriends)
        recyclerView.adapter = adapter
        loadFriends()
        return view
    }
    private fun loadFriends() {
        val url = "http://10.0.2.2/get_friends.php"
        val request = object : StringRequest(
            Method.POST,
            url,
            { response ->
                try {
                    val obj = JSONObject(response)
                    val result = obj.getString("result")
                    if (result == "OK") {
                        val arr = obj.getJSONArray("data")
                        listFriends.clear()
                        for (i in 0 until arr.length()) {
                            val o = arr.getJSONObject(i)
                            val mhs = Mahasiswa(
                                o.getString("nama"),
                                o.getString("nrp"),
                                "",
                                "",
                                "",
                                "",
                                0,
                                o.getString("photo_url")
                            )

                            listFriends.add(mhs)
                        }
                        adapter.notifyDataSetChanged()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            },
            {
            }
        ) { override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["user_nrp"] = "160421000"
                return params
            }
        }
        Volley.newRequestQueue(activity).add(request)
    }

}

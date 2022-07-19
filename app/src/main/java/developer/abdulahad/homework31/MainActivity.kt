package developer.abdulahad.homework31

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.*
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import developer.abdulahad.homework31.adapter.RvAdapter
import developer.abdulahad.homework31.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var url = "https://api.github.com/users"
    lateinit var rvAdapter: RvAdapter
    lateinit var request: RequestQueue
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        request = Volley.newRequestQueue(binding.root.context)
        VolleyLog.DEBUG = true

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, "https://api.github.com/users", null,
            { response ->
                val type = object : TypeToken<List<GsonClassItem>>() {}.type
                val list = Gson().fromJson<List<GsonClassItem>>(response.toString(), type)

                rvAdapter = RvAdapter(list)
                binding.rv.adapter = rvAdapter

                Log.d(TAG, "onResponse : ${response.toString()}")
            }, object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError?) {

                }
            })

        request.add(jsonArrayRequest)
    }
}
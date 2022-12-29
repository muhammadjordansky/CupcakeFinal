/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.cupcake

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.cupcake.databinding.FragmentSummaryBinding

//[SummaryFragment] berisi ringkasan detail pesanan dengan tombol untuk berbagi pesanan melalui aplikasi lain.
class SummaryFragment : Fragment() {

    // Mengikat instance objek yang sesuai dengan tata letak fragment_summary.xml
    // Properti ini bukan nol antara callback siklus hidup onCreateView() dan onDestroyView(),
    // saat hierarki tampilan dilampirkan ke fragmen.
    private var binding: FragmentSummaryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSummaryBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            sendButton.setOnClickListener { sendOrder() }
        }
    }

   //Kirim pesanan dengan membagikan detail pesanan ke aplikasi lain melalui maksud implisit.

    fun sendOrder() {
        Toast.makeText(activity, "Send Order", Toast.LENGTH_SHORT).show()
    }

    //Metode lifecycle fragmen ini dipanggil saat hierarki tampilan yang terkait dengan fragmen dihapus. Akibatnya, bersihkan objek yang mengikat.
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
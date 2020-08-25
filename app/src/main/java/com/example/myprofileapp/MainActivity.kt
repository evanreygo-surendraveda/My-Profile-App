package com.example.myprofileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener { ValidasiInput() }

        setDataSpinnerGender()

    }

    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(this, R.array.gender_list, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerGender.adapter = adapter
    }

    private fun ValidasiInput() {
        val namaInput = edtName.text.toString()
        val emailInput = edtEmail.text.toString()
        val telpInput = edtTelp.text.toString()
        val alamatInput = edtAlamat.text.toString()
        val genderInput = spinnerGender.selectedItem.toString()

        when {
            namaInput.isEmpty() -> edtName.error = "Nama harus diisi!"
            genderInput.equals("Pilih Jenis Kelamin") -> Toast.makeText(
                this,
                "Jenis Kelamin harus diisi!",
                Toast.LENGTH_SHORT
            ).show()
            emailInput.isEmpty() -> edtEmail.error = "Alamat Email harus diisi!"
            telpInput.isEmpty() -> edtTelp.error = "No. Telepon harus diisi!"
            alamatInput.isEmpty() -> edtAlamat.error = "Alamat harus diisi!"

            else -> {
                Toast.makeText(this, "Navigasi ke halaman profil diri", Toast.LENGTH_SHORT).show()
                pindahActivity()
            }
        }
    }

    private fun pindahActivity() {
        val intent = Intent(this, MyProfileActivity::class.java)

        val bundle = Bundle()

        val namaInput = edtName.text.toString()
        val emailInput = edtEmail.text.toString()
        val telpInput = edtTelp.text.toString()
        val alamatInput = edtAlamat.text.toString()
        val genderInput = spinnerGender.selectedItem.toString()

            bundle.putString ("nama", namaInput)
            bundle.putString("gender", genderInput)
            bundle.putString("email", emailInput)
            bundle.putString("telp", telpInput)
            bundle.putString("alamat", alamatInput)

        intent.putExtras(bundle)

        startActivity(intent)

    }
}

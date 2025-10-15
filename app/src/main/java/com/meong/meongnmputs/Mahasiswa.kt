package com.meong.meongnmputs

data class Mahasiswa(
    var nama: String,
    var nrp: String,
    var aboutMe: String,
    var prodi: String

){
    companion object {
        val prodi = arrayOf("DSAI", "NCS", "IMES", "DMT", "GD");
    }
}

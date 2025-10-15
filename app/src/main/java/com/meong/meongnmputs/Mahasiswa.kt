package com.meong.meongnmputs

data class Mahasiswa(
    var nama: String,
    var nrp: String,
    var aboutMe: String,
    var myCourse: String,
    var myExperience: String,
    var prodi: String,
    var imageId: Int

){
    companion object {
        val prodi = arrayOf("DSAI", "NCS", "IMES", "DMT", "GD");
    }
}

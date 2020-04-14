package perpustakaan;

public class MVC_Peminjaman {
    ViewPeminjaman viewPeminjaman = new ViewPeminjaman();
    ModelPerpustakaan modelPerpustakaan = new ModelPerpustakaan();
    ControllerPeminjaman controllerPeminjaman = new ControllerPeminjaman(viewPeminjaman, modelPerpustakaan);
}

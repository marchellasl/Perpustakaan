package perpustakaan;

public class MVC_Anggota {
    ViewAnggota viewAnggota = new ViewAnggota();
    ModelPerpustakaan modelPerpustakaan = new ModelPerpustakaan();
    ControllerAnggota controllerAnggota = new ControllerAnggota(viewAnggota, modelPerpustakaan);
}

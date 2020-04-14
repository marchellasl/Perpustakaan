package perpustakaan;

public class MVC_Karyawan {
    ViewKaryawan viewKaryawan = new ViewKaryawan();
    ModelPerpustakaan modelPerpustakaan = new ModelPerpustakaan();
    ControllerKaryawan controllerKaryawan = new ControllerKaryawan(viewKaryawan, modelPerpustakaan);
}

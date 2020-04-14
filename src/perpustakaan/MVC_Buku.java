package perpustakaan;

public class MVC_Buku {
    ViewBuku viewBuku = new ViewBuku();
    ModelPerpustakaan modelPerpustakaan = new ModelPerpustakaan();
    ControllerBuku controllerBuku = new ControllerBuku(viewBuku, modelPerpustakaan);
}

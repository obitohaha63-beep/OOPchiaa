import java.io.IOException;

public class QLBH {
    // === CAC DANH SACH TOAN CUC (STATIC) ===
    protected static DsPhieuNhapHang dspnh = new DsPhieuNhapHang();
    protected static DsChiTietPNH dsctpnh = new DsChiTietPNH();
    protected static DsNhaCungCap dsncc = new DsNhaCungCap();

    public QLBH() {}

    // === DOC DU LIEU TU FILE ===
    public void napDuLieuTuFile() {
        System.out.println("=== Dang nap du lieu tu file... ===");
        dsncc.docFile();
        dspnh.docFile();
        dsctpnh.docFile();
        System.out.println("=== Nap du lieu hoan tat! ===");
    }

    // === MENU CHINH (de da hinh, khong code cu the) ===
    public void menuChinh() throws IOException {
        // ham nay de lop con override
    }

    // === THONG KE TOAN BO HE THONG ===
    public void thongKeTong() {
        System.out.println("\n===== THONG KE TOAN BO HE THONG =====");
        dsctpnh.thongke();
        int tongNCC_HCM = dsncc.thongketheodouong();
        System.out.println("So nha cung cap o TPHCM: " + tongNCC_HCM);
    }
}

import java.io.IOException;
import java.util.Scanner;

public class HeThong {
    private QLBH qlbh;

    public void menuChinh() throws IOException {
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("\n========== HE THONG QUAN LY BAN HANG ==========");
            System.out.println("1. Quan ly phieu nhap hang");
            System.out.println("2. Thong ke tong he thong");
            System.out.println("0. Thoat chuong trinh");
            System.out.print("Nhap lua chon: ");
            chon = sc.nextInt();

            switch (chon) {
                case 1:
                    qlbh = new QLPNH();  // da hinh
                    qlbh.menuChinh();
                    break;
                case 2:
                    if (qlbh == null) qlbh = new QLPNH();
                    qlbh.thongKeTong();
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }

    public static void main(String[] args) throws IOException {
        HeThong ht = new HeThong();
        ht.menuChinh();
    }
}

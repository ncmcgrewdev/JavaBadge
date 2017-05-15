/**
 * Created by ncmcgrew on 5/15/2017.
 */
public class Hyundai {
    public enum Model {
        ACCENT(14674), SONATA(20996), ELANTRA(16997), AZERA(32916), EQUUS(54931);

        private int fairPurchasePrice;

        private Model(int price){
            this.fairPurchasePrice = price;
        }
    }
}

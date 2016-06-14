/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Krypto;

import java.util.PriorityQueue;

/**
 *
 * @author Mattis
 */
public class Rot13 {

    private Rot13() {
    }

    public static void main(String[] args) {
        // Rot13.frequencyAnalysis("AABCAADEC");
        
        String analys = "CGZNL YJBEN QYDLQ ZQSUQ NZCYD "
                + "SNQVU BFGBK GQUQZ QSUQN UZCYD SNJDS UDCXJ "
                + "ZCYDS NZQSU QNUZB WSBNZ QSUQN UDCXJ CUBGS "
                + "BXJDS UCTYV SUJQG WTBUJ KCWSV LFGBK GSGZN "
                + "LYJCB GJSZD GCHMS UCJCU QJLYS BXUMA UJCJM "
                + "JCBGZ CYDSN CGKDC ZDSQZ DVSJJ SNCGJ DSYVQ "
                + "CGJSO JCUNS YVQZS WALQV SJJSN UBTSX COSWG "
                + "MTASN BXYBU CJCBG UWBKG JDSQV YDQAS JXBNS "
                + "OQTYV SKCJD QUDCX JBXQK BMVWA SNSYV QZSWA "
                + "LWAKB MVWAS ZBTSS QGWUB BGJDS TSJDB WCUGQ "
                + "TSWQX JSNRM VCMUZ QSUQN KDBMU SWCJJ BZBTT "
                + "MGCZQ JSKCJ DDCUE SGSNQ VUJDS SGZNL YJCBG "
                + "UJSYY SNXBN TSWAL QZQSU QNZCY DSNCU BXJSG "
                + "CGZBN YBNQJ SWQUY QNJBX TBNSZ BTYVS OUZDS "
                + "TSUUM ZDQUJ DSICE SGNSZ CYDSN QGWUJ CVVDQ "
                + "UTBWS NGQYY VCZQJ CBGCG JDSNB JULUJ STQUK "
                + "CJDQV VUCGE VSQVY DQASJ UMAUJ CJMJC BGZCY "
                + "DSNUJ DSZQS UQNZC YDSNC USQUC VLANB FSGQG "
                + "WCGYN QZJCZ SBXXS NUSUU SGJCQ VVLGB ZBTTM "
                + "GCZQJ CBGUS ZMNCJ LUDQF SUYSQ NSYNB WMZSW "
                + "TBUJB XDCUF GBKGK BNFAS JKSSG QGWDC USQNV "
                + "LYVQL UKSNS TQCGV LZBTS WCSUQ GWDCU JBNCS "
                + "UESGN SUDSN QCUSW JBJDS YSQFB XUBYD CUJCZ "
                + "QJCBG QGWQN JCUJN LALJD SSGWB XJDSU COJSS "
                + "GJDZS GJMNL GSOJD SKNBJ STQCG VLJNQ ESWCS "
                + "UMGJC VQABM JCGZV MWCGE DQTVS JFCGE VSQNQ "
                + "GWTQZ ASJDZ BGUCW SNSWU BTSBX JDSXC GSUJS "
                + "OQTYV SUCGJ DSSGE VCUDV QGEMQ ESCGD CUVQU "
                + "JYDQU SDSKN BJSJN QECZB TSWCS UQVUB FGBKG "
                + "QUNBT QGZSU QGWZB VVQAB NQJSW KCJDB JDSNY "
                + "VQLKN CEDJU TQGLB XDCUY VQLUK SNSYM AVCUD "
                + "SWCGS WCJCB GUBXI QNLCG EHMQV CJLQG WQZZM "
                + "NQZLW MNCGE DCUVC XSJCT SQGWC GJKBB XDCUX "
                + "BNTSN JDSQJ NCZQV ZBVVS QEMSU YMAVC UDSWJ "
                + "DSXCN UJXBV CBQZB VVSZJ SWSWC JCBGB XDCUW "
                + "NQTQJ CZKBN FUJDQ JCGZV MWSWQ VVAMJ JKBBX "
                + "JDSYV QLUGB KNSZB EGCUS WQUUD QFSUY SQNSU"
                + "DSNSM YBGVS ENQGW QNBUS KCJDQ"
                + " ENQIS QGWUJ QJSVL QCNQG WANBM EDJTS JDSAS "
                + "SJVSX NBTQE VQUUZ QUSCG KDCZD CJKQU SGZVB "
                + "USWCJ KQUQA SQMJC XMVUZ QNQAQ SMUQG WQJJD "
                + "QJJCT SMGFG BKGJB GQJMN QVCUJ UBXZB MNUSQ "
                + "ENSQJ YNCPS CGQUZ CSGJC XCZYB CGJBX ICSKJ "
                + "DSNSK SNSJK BNBMG WAVQZ FUYBJ UGSQN BGSSO "
                + "JNSTC JLBXJ DSAQZ FQGWQ VBGEB GSGSQ NJDSB "
                + "JDSNJ DSUZQ VSUKS NSSOZ SSWCG EVLDQ NWQGW "
                + "EVBUU LKCJD QVVJD SQYYS QNQGZ SBXAM NGCUD "
                + "SWEBV WJDSK SCEDJ BXJDS CGUSZ JKQUI SNLNS "
                + "TQNFQ AVSQG WJQFC GEQVV JDCGE UCGJB ZBGUC "
                + "WSNQJ CBGCZ BMVWD QNWVL AVQTS RMYCJ SNXBN "
                + "DCUBY CGCBG NSUYS ZJCGE CJ"
                + "QVJDB MEDGB QJJSG WQGZS NSZBN WUXBN JDSYS "
                + "NCBWU MNICI STBUJ ACBEN QYDSN UQENS SJDQJ "
                + "UDQFS UYSQN SKQUS WMZQJ SWQJJ DSFCG EUGSK "
                + "UZDBB VCGUJ NQJXB NWQXN SSUZD BBVZD QNJSN "
                + "SWCGQ ABMJQ HMQNJ SNBXQ TCVSX NBTDC UDBTS "
                + "ENQTT QNUZD BBVUI QNCSW CGHMQ VCJLW MNCGE "
                + "JDSSV CPQAS JDQGS NQAMJ JDSZM NNCZM VMTKQ "
                + "UWCZJ QJSWA LVQKJ DNBME DBMJS GEVQG WQGWJ "
                + "DSUZD BBVKB MVWDQ ISYNB ICWSW QGCGJ SGUCI "
                + "SSWMZ QJCBG CGVQJ CGENQ TTQNQ GWJDS ZVQUU "
                + "CZUQJ JDSQE SBXUD QFSUY SQNST QNNCS WJDSL "
                + "SQNBV WQGGS DQJDQ KQLJD SZBGU CUJBN LZBMN "
                + "JBXJD SWCBZ SUSBX KBNZS UJSNC UUMSW QTQNN "
                + "CQESV CZSGZ SBGGB ISTAS NJKBB XDQJD QKQLU "
                + "GSCED ABMNU YBUJS WABGW UJDSG SOJWQ LQUUM "
                + "NSJLJ DQJJD SNSKS NSGBC TYSWC TSGJU JBJDS "
                + "TQNNC QESJD SZBMY VSTQL DQISQ NNQGE SWJDS "
                + "ZSNST BGLCG UBTSD QUJSU CGZSJ DSKBN ZSUJS "
                + "NZDQG ZSVVB NQVVB KSWJD STQNN CQESA QGGUJ "
                + "BASNS QWBGZ SCGUJ SQWBX JDSMU MQVJD NSSJC "
                + "TSUQG GSUYN SEGQG ZLZBM VWDQI SASSG JDSNS "
                + "QUBGX BNJDC UUCOT BGJDU QXJSN JDSTQ NNCQE "
                + "SUDSE QISAC NJDJB QWQME DJSNU MUQGG QKDBK "
                + "QUAQY JCUSW BGTQL JKCGU UBGDQ TGSJQ GWWQM "
                + "EDJSN RMWCJ DXBVV BKSWQ VTBUJ JKBLS QNUVQ "
                + "JSNQG WKSNS AQYJC USWBG XSANM QNLDQ TGSJW "
                + "CSWBX MGFGB KGZQM USUQJ JDSQE SBXQG WKQUA "
                + "MNCSW BGQME MUJQX JSNJD SACNJ DBXJD SJKCG "
                + "UJDSN SQNSX SKDCU JBNCZ QVJNQ ZSUBX UDQFS "
                + "UYSQN SMGJC VDSCU TSGJC BGSWQ UYQNJ BXJDS "
                + "VBGWB GJDSQ JNSUZ SGSCG ASZQM USBXJ DCUEQ "
                + "YUZDB VQNUN SXSNJ BJDSL SQNUA SJKSS GQGWQ "
                + "UUDQF SUYSQ NSUVB UJLSQ NUACB ENQYD SNUQJ "
                + "JSTYJ CGEJB QZZBM GJXBN JDCUY SNCBW DQISN "
                + "SYBNJ SWTQG LQYBZ NLYDQ VUJBN CSUGC ZDBVQ "
                + "UNBKS UDQFS UYSQN SUXCN UJACB ENQYD SNNSZ "
                + "BMGJS WQUJN QJXBN WVSES GWJDQ JUDQF SUYSQ "
                + "NSXVS WJDSJ BKGXB NVBGW BGJBS UZQYS YNBUS "
                + "ZMJCB GXBNW SSNYB QZDCG EQGBJ DSNSC EDJSS "
                + "GJDZS GJMNL UJBNL DQUUD QFSUY SQNSU JQNJC "
                + "GEDCU JDSQJ NCZQV ZQNSS NTCGW CGEJD SDBNU "
                + "SUBXJ DSQJN SYQJN BGUCG VBGWB GRBDG QMANS "
                + "LNSYB NJSWJ DQJUD QFSUY SQNSD QWASS GQZBM "
                + "GJNLU ZDBBV TQUJS NUBTS JKSGJ CSJDZ SGJMN "
                + "LUZDB VQNUD QISUM EESUJ SWJDQ JUDQF SUYSQ "
                + "NSTQL DQISA SSGST YVBLS WQUQU ZDBBV TQUJS "
                + "NALQV SOQGW SNDBE DJBGB XVQGZ QUDCN SQZQJ "
                + "DBVCZ VQGWB KGSNK DBGQT SWQZS NJQCG KCVVC "
                + "QTUDQ FSUDQ XJSCG DCUKC VVGBS ICWSG ZSUMA "
                + "UJQGJ CQJSU UMZDU JBNCS UBJDS NJDQG DSQNU "
                + "QLZBV VSZJS WQXJS NDCUW SQJD";
                
        /*Rot13.frequencyAnalysis("CGZNL YJBEN QYDLQ ZQSUQ NZCYD "
                + "SNQVU BFGBK GQUQZ QSUQN UZCYD SNJDS UDCXJ "
                + "ZCYDS NZQSU QNUZB WSBNZ QSUQN UDCXJ CUBGS "
                + "BXJDS UCTYV SUJQG WTBUJ KCWSV LFGBK GSGZN "
                + "LYJCB GJSZD GCHMS UCJCU QJLYS BXUMA UJCJM "
                + "JCBGZ CYDSN CGKDC ZDSQZ DVSJJ SNCGJ DSYVQ "
                + "CGJSO JCUNS YVQZS WALQV SJJSN UBTSX COSWG "
                + "MTASN BXYBU CJCBG UWBKG JDSQV YDQAS JXBNS "
                + "OQTYV SKCJD QUDCX JBXQK BMVWA SNSYV QZSWA "
                + "LWAKB MVWAS ZBTSS QGWUB BGJDS TSJDB WCUGQ "
                + "TSWQX JSNRM VCMUZ QSUQN KDBMU SWCJJ BZBTT "
                + "MGCZQ JSKCJ DDCUE SGSNQ VUJDS SGZNL YJCBG "
                + "UJSYY SNXBN TSWAL QZQSU QNZCY DSNCU BXJSG "
                + "CGZBN YBNQJ SWQUY QNJBX TBNSZ BTYVS OUZDS "
                + "TSUUM ZDQUJ DSICE SGNSZ CYDSN QGWUJ CVVDQ "
                + "UTBWS NGQYY VCZQJ CBGCG JDSNB JULUJ STQUK "
                + "CJDQV VUCGE VSQVY DQASJ UMAUJ CJMJC BGZCY "
                + "DSNUJ DSZQS UQNZC YDSNC USQUC VLANB FSGQG "
                + "WCGYN QZJCZ SBXXS NUSUU SGJCQ VVLGB ZBTTM "
                + "GCZQJ CBGUS ZMNCJ LUDQF SUYSQ NSYNB WMZSW "
                + "TBUJB XDCUF GBKGK BNFAS JKSSG QGWDC USQNV "
                + "LYVQL UKSNS TQCGV LZBTS WCSUQ GWDCU JBNCS "
                + "UESGN SUDSN QCUSW JBJDS YSQFB XUBYD CUJCZ "
                + "QJCBG QGWQN JCUJN LALJD SSGWB XJDSU COJSS "
                + "GJDZS GJMNL GSOJD SKNBJ STQCG VLJNQ ESWCS "
                + "UMGJC VQABM JCGZV MWCGE DQTVS JFCGE VSQNQ "
                + "GWTQZ ASJDZ BGUCW SNSWU BTSBX JDSXC GSUJS "
                + "OQTYV SUCGJ DSSGE VCUDV QGEMQ ESCGD CUVQU "
                + "JYDQU SDSKN BJSJN QECZB TSWCS UQVUB FGBKG "
                + "QUNBT QGZSU QGWZB VVQAB NQJSW KCJDB JDSNY "
                + "VQLKN CEDJU TQGLB XDCUY VQLUK SNSYM AVCUD "
                + "SWCGS WCJCB GUBXI QNLCG EHMQV CJLQG WQZZM "
                + "NQZLW MNCGE DCUVC XSJCT SQGWC GJKBB XDCUX "
                + "BNTSN JDSQJ NCZQV ZBVVS QEMSU YMAVC UDSWJ "
                + "DSXCN UJXBV CBQZB VVSZJ SWSWC JCBGB XDCUW "
                + "NQTQJ CZKBN FUJDQ JCGZV MWSWQ VVAMJ JKBBX "
                + "JDSYV QLUGB KNSZB EGCUS WQUUD QFSUY SQNSU");/**/
        
        /*Rot13.frequencyAnalysis("DSNSM YBGVS ENQGW QNBUS KCJDQ"
                + " ENQIS QGWUJ QJSVL QCNQG WANBM EDJTS JDSAS "
                + "SJVSX NBTQE VQUUZ QUSCG KDCZD CJKQU SGZVB "
                + "USWCJ KQUQA SQMJC XMVUZ QNQAQ SMUQG WQJJD "
                + "QJJCT SMGFG BKGJB GQJMN QVCUJ UBXZB MNUSQ "
                + "ENSQJ YNCPS CGQUZ CSGJC XCZYB CGJBX ICSKJ "
                + "DSNSK SNSJK BNBMG WAVQZ FUYBJ UGSQN BGSSO "
                + "JNSTC JLBXJ DSAQZ FQGWQ VBGEB GSGSQ NJDSB "
                + "JDSNJ DSUZQ VSUKS NSSOZ SSWCG EVLDQ NWQGW "
                + "EVBUU LKCJD QVVJD SQYYS QNQGZ SBXAM NGCUD "
                + "SWEBV WJDSK SCEDJ BXJDS CGUSZ JKQUI SNLNS "
                + "TQNFQ AVSQG WJQFC GEQVV JDCGE UCGJB ZBGUC "
                + "WSNQJ CBGCZ BMVWD QNWVL AVQTS RMYCJ SNXBN "
                + "DCUBY CGCBG NSUYS ZJCGE CJ");/**/
        
        // Rot13.frequencyAnalysis(analys);
        
        String testText = Rot13.ceasersCodeCrypt("HELLO THIS IS MY TEST RUN WITH A"
                + "LONG LONG TEXT BUT IT DOES NOT SEEM TO USE ALL THAT MANY", 4);
        
        String testText2 = "LIVITCSWPIYVEWHEVSRIQMXLEYVEOIEWHRXEXIPFEMVEWHKVSTYLXZIXLIKIIXPIJVSZEYPERRGERIM"
                + "WQLMGLMXQERIWGPSRIHMXQEREKIETXMJTPRGEVEKEITREWHEXXLEXXMZITWAWSQWXSWEXTVEPMRXRSJ"
                + "GSTVRIEYVIEXCVMUIMWERGMIWXMJMGCSMWXSJOMIQXLIVIQIVIXQSVSTWHKPEGARCSXRWIEVSWIIBXV"
                + "IZMXFSJXLIKEGAEWHEPSWYSWIWIEVXLISXLIVXLIRGEPIRQIVIIBGIIHMWYPFLEVHEWHYPSRRFQMXLE"
                + "PPXLIECCIEVEWGISJKTVWMRLIHYSPHXLIQIMYLXSJXLIMWRIGXQEROIVFVIZEVAEKPIEWHXEAMWYEPP"
                + "XLMWYRMWXSGSWRMHIVEXMSWMGSTPHLEVHPFKPEZINTCMXIVJSVLMRSCMWMSWVIRCIGXMWYMX";
        // System.out.println("testText = " + testText);
        // Rot13.frequencyAnalysis(testText2);
        // System.out.println(Rot13.code("YRIRY GJB CNFFJBEQ EBGGRA"));
        
        /*for(int i = 0; i < 26; i++){
            System.out.println(Rot13.ceasersCodeDecrypt("OMQEMDUEQMEK", i));
        }/**/
        
        for(int i = 0; i < 26; i++){
            System.out.println(Rot13.ceasersCodeDecrypt("KSVVW BGSJD SVSIS VXBMN YQUUK BNWCU ANMJS", i));
            
            System.out.println("\ntestar nästa\n\n\n");
        }
        
    }

    public static String code(String text) {
        String temp = "";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 65 && text.charAt(i) <= 90) {
                char tempChar = text.charAt(i);
                tempChar += 13;
                if (tempChar > 90) {
                    tempChar = (char) (65 + (tempChar - 91));
                }
                temp += tempChar;
            } else if (text.charAt(i) >= 97 && text.charAt(i) <= 122) {
                char tempChar = text.charAt(i);
                tempChar += 13;
                if (tempChar > 122) {
                    tempChar = (char) (97 + (tempChar - 123));
                }
                temp += tempChar;
            } else {
                // System.out.println("non char");
                temp += text.charAt(i);
            }
        }

        return temp;
    }

    public static String ceasersCodeCrypt(String text, int key) {
        String temp = "";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 65 && text.charAt(i) <= 90) {
                char tempChar = text.charAt(i);
                tempChar += key;
                if (tempChar > 90) {
                    tempChar = (char) (65 + (tempChar - 91));
                }
                temp += tempChar;
            } else if (text.charAt(i) >= 97 && text.charAt(i) <= 122) {
                char tempChar = text.charAt(i);
                tempChar += key;
                if (tempChar > 122) {
                    tempChar = (char) (97 + (tempChar - 123));
                }
                temp += tempChar;
            } else {
                // System.out.println("non char");
                temp += text.charAt(i);
            }
        }

        return temp;
    }

    public static String ceasersCodeDecrypt(String text, int key) {
        String temp = "";

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 65 && text.charAt(i) <= 90) {
                char tempChar = text.charAt(i);
                tempChar -= key;
                if (tempChar < 65) {
                    tempChar = (char) (91 - (65 - tempChar));
                }
                temp += tempChar;
            } else if (text.charAt(i) >= 97 && text.charAt(i) <= 122) {
                char tempChar = text.charAt(i);
                tempChar -= key;
                if (tempChar < 97) {
                    tempChar = (char) (123 - (97 - tempChar));
                }
                temp += tempChar;
            } else {
                // System.out.println("non char");
                temp += text.charAt(i);
            }
        }

        return temp;
    }

    /**
     * assuming input is upper case and only letters for now
     *
     * @param text
     */
    public static void frequencyAnalysis(String text) {
        FrequencyTable table = new FrequencyTable();
        
        text = text.toUpperCase();
        
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) < 65 || text.charAt(i) > 90) {
                // System.out.println("non alpha letter");
            } else {
                table.addToCount(text.charAt(i));
            }
        }

        System.out.println(table.getMostLikely(text));
    }
}

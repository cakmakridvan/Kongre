package com.rota.kongresistem.fragment;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rota.kongresistem.R;
import com.rota.kongresistem.activity.Details;
import com.rota.kongresistem.adapter.Tab1Adapter;


public class Tab1 extends Fragment implements View.OnClickListener {

    private ListView listView;
    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    View inflate;
    private TextView title;
    private String clilcked_btn = "";
//for Salon 3
    String[] txt_clock ={
            "10:00-10:40",
            "10:40-11:00","11:00-11:20",
            "11:20-11:40","11:40-12:00",

            "16:20 - 16:40","16:40 - 17:00",
            "17:00 - 17:20","17:20 - 17:40",
            "17:40 - 18:00"
    };

    String[] txt_title  ={
            "AÇILIŞ SUNUMLARI","ŞÜKRÜ ERSOY, ÖZCAN ERDOĞAN, FİLİZ KATMAN, SERHAT YILMAZ (9731)",
            "REZA SABER, VEYSEL IŞIK, AYŞE ÇAĞLAYAN (9897)","EFNAN ŞORA GÜNAL, UĞUR GÜREL (9907)",
            "ŞENER CERYAN (9959)",

            "GÜLTEN ÇAMALAN, A. SERAP AKGÜNDÜZ, S. ÇETİN, H. ARABACI (9734)",
            "İSMAİL KAYA, ALİ TOLGA ÖZDEN (9794)","AYHAN SAYIN, MEHMET AKSOY, OSMAN ÇAYLAK, SELÇUK TÜTÜNCÜ (9845)","MURAT YILDIRIM (9924)",""

    };

    String[] txt_konu = {"","İNSANOĞLUNU BEKLEYEN TEHLİKELER\n" +
            "HAZARDS FOR HUMANKIND","ARAS FAY ZONU BOYUNCA (KB İRAN) MORFOMETRİK VE INSAR VERİ ANALİZİYLE DOĞAL AFET RİSKLERİNİN BELİRLENMESİ\n" +
            "DETERMİNATİON OF NATURAL DİSASTER RİSKS ALONG ARAS FAULT ZONE (NW IRAN) USİNG MORPHOMETRİC AND INSAR DATA ANALYSİS\n","YERALTI MADENLERİNDE SİSMİK AKTİVİTELERİN TAHMİNİ İÇİN ÖZNİTELİKLERİN ANALİZİ\n" +
            "ANALYSİS OF FEATURES FOR PREDİCTİON OF SEİSMİC ACTİVİTİES İN UNDERGROUND MİNES\n","ALTINOLUK-GÜRE (BALIKESİR) YERLEŞİM ALANININ SIVILAŞMA ŞİDETİ VE FAYLARDAN UZAKLIĞIN BİRLİKTE KULLANILARAK MİKRO-BÖLGELENDİRİLMESİ\n" +
            "THE MİCROZONATİON OF THE SETTLEMENT AREA OF ALTINOLUK-GÜRE (BALIKESİR) USİNG THE LİQUEFACTİON SEVERİTY INDEX AND DİSTANCE FROM FAULTS TOGETHER",

            "TÜRKİYE METEOROLOJİK KURAKLIK PROJEKSİYONLARI\n" +
                    "METEOROLOGICAL DROUGHT PROJECTIONS IN TURKEY","TÜRKİYE'DE DİRENÇLİ KENTLER İÇİN İKLİM DEĞİŞİMİNE UYUM YAKLAŞIMLARINDA TABANDAN YUKARI YAPILANMANIN ÖNEMİ\n" +
            "IMPORTANCE OF BOTTOM-UP STRUCTURİNG İN CLİMATE CHANGE ADAPTATİON APPROACHES FOR RESİLİENT CİTİES İN TURKEY","METEOROLOJİK KAYNAKLI TEHLİKELERE KARŞI UÇTAN UCA ERKEN UYARI SİSTEMİ\n" +
            "ON THE END-TO-END EARLY WARNİNG SYSTEM FOR METEOROLOGİCAL INDUCED HAZARDS","TÜRKİYE GENELİ VE COĞRAFİ BÖLGELERİN UZUN YILLAR KURAKLIK ANALİZİNİN YAPILMASI VE KURAKLIK EĞİLİMİNİN ARAŞTIRILMASI\n" +
            "LONG-TERM DROUGHT ANALYSIS AND THE RESEARCH OF DROUGHT TENDENCY FOR TURKEY AND ITS GEOGRAPHICAL REGIONS\n",""

    };

    String[] oturum_baskan = {
            "ŞÜKRÜ ERSOY","ŞÜKRÜ ERSOY","ŞÜKRÜ ERSOY","ŞÜKRÜ ERSOY","ŞÜKRÜ ERSOY",
            "HİKMET EROĞLU","HİKMET EROĞLU","HİKMET EROĞLU","HİKMET EROĞLU","HİKMET EROĞLU"
    };

//for Salon 5
    String[] txt_clock2 ={
            "10:00-10:40"
    };

    String[] txt_title2 ={
            "AÇILIŞ SUNUMLARI","YUSUF ZAHİT GÜNDOĞDU, GÖRKEM İÇÖZ, YASİN ARSLAN (9473)","HÜSEYİN MUNGAN, DİLEK CANSU BOZACIOĞLU, AYŞE BENGÜ SÜNBÜL, ÖMER FARUK ÇAPAR (9634)",
            "HÜLAGÜ ETHEMOĞLU (9795)","GÖKHAN DEMİR, AHMET İDİKURT, UTKU KÖKTAN, MUZAFFER KEREM ERTEK (9944)",

            "EBRU İNAL, NİLGÜN OKAY (9087)","NÜKET PAKSOY ERBAYDAR, EBRU İNAL, EDİP KAYA (9089)","SEVDA DEMİRÖZ YILDIRIM, FATMA GÜNDÜZ AKAN (9630)",
            "FATMA GÜNDÜZ AKAN, SEVDA DEMİRÖZ YILDIRIM (9737)","DERYA DEMİRDİZEN ÇEVİK (9758)"
    };

    String[] txt_konu2 = {"","ZEMİN ENJEKSİYON YÖNTEMİ İLE MEVCUT BİR ÜRETİM TESİSİNDEKİ SIVILAŞMA RİSKİNİN GİDERİLMESİ\n" +
            "MITIGATION OF SOIL LIQUEFACTION OF AN EXISTING PRODUCTION FACILITY BY INJECTION METHOD","SONLU ELEMANLARA DAYALI SAYISAL MODEL ANALİZİ; SIVILAŞABİLİR ZEMİNE UYGULANAN ZEMİN İYİLEŞTİRME\n" +
            "NUMERICAL ANALYSIS USING FINITE ELEMENT METHOD; SOIL IMPROVEMENT ON LIQUEFY AREA","ZEMİN YAPI ETKİLEŞİMİNİN HASAR OLASILIĞINA ETKİSİ\n" +
            "EFFECT SOİL STRUCTURE İNTERACTİON ON THE PROBABİLİTY OF DAMAGE","DERİN KAZILARDA İKSA SİSTEMLERİNİN TASARIM DEFORMASYONLARININ ALETSEL GÖZLEMLERLE KARŞILAŞTIRILMASI\n" +
            "COMPARISON OF DESIGN DEFORMATIONS OF SHORING SYSTEMS IN DEEP EXCAVATIONS WITH INSTRUMENTAL OBSERVATIONS",

            "AFETE DİRENÇLİLİK BAKIMINDAN BİR YÜKSEKOKULUN AFET RİSK YÖNETİMİ PLANLAMA SÜREÇLERİNİN DEĞERLENDİRİLMESİ\n" +
                    "ASSESSING OF DISASTER MANAGEMENT PLANNING PROCESSES OF A COLLEGE TOWARDS DISASTER RESILIENCE","TÜRKİYE’NİN AFET MEVZUATININ DEĞERLENDİRİLMESİ: TOPLUMSAL CİNSİYETE DUYARLI MIDIR?\n" +
            "EVALUATİON OF TURKEY’S DİSASTER LEGİSLATİON: IS İT GENDER SENSİTİVE?\n","AFETLERE KARŞI DİRENÇLİ TOPLUM OLUŞTURMADA KADININ ROLÜ\n" +
            "THE ROLE OF WOMEN IN RESISTANT SOCIETY CREATION AGAINST DISASTERS\n","TÜRKİYE’NİN AVRUPA BİRLİĞİNE UYUM SÜRECİNDE KADIN HAKLARI VE TOPLUMSAL CİNSİYETE DUYARLI AFET YÖNETİMİ\n" +
            "TURKEY'S WOMEN'S RİGHTS AND GENDER SENSİTİVE DİSASTER MANAGEMENT İN THE PROCESS COMPLİANCE WİTH EUROPEAN UNİON\n","AFET SONRASI SÜRECİ TOPLUMSAL CİNSİYET BAĞLAMINDA TARTIŞMAK\n" +
            "UNDERSTANDİNG OF POST-DİSASTER MANAGEMENT PROCESS WİTHİN THE CONTEXT OF GENDER"

    };

    String[] oturum_baskan2 = {
            "HÜLAGÜ ETHEMOĞLU","HÜLAGÜ ETHEMOĞLU","HÜLAGÜ ETHEMOĞLU","HÜLAGÜ ETHEMOĞLU","HÜLAGÜ ETHEMOĞLU",

            "NİLGÜN OKAY","NİLGÜN OKAY","NİLGÜN OKAY","NİLGÜN OKAY","NİLGÜN OKAY"
    };
//for Salon 6
    String[] txt_title3 ={
            "AÇILIŞ SUNUMLARI","HANNA RİYANTO (10012)","NİLÜFER AKINCITÜRK, EBRU GÜNAÇAR, AYŞE BETÜL YAZICI (10072)","HATİCE GÜNSELİ DEMİRKOL (10087",
            "DENİZ ÖZGE AYTAÇ, TÜLİN VURAL ARSLAN (10096)",

        "ZAFER GENÇ, FAHRİ BİRİNCİ (9494)","RECEP BAKIŞ, YILDIRIM BAYAZIT, FATMA ÇİĞDEM ŞİRİN (9667)","FATMA ÇİĞDEM ŞİRİN, RECEP BAKIŞ, YILDIRIM BAYAZIT (9675)",
        "GÖKHAN AL, MEHMET İNANÇ ONUR (9721)",""
    };

    String[] txt_konu3 ={
            "","AFET SONRASI DURUMLARDA ALANLAR İÇİNDEKİ GÜVENLİK AÇIĞINI EN AZA İNDİRME KÜLTÜR VE MÜLTECİ KATILIMI SAYESİNDE.\n" +
            "MİNİMİZİNG VULNERABİLİTY WİTHİN SPACES IN POST DİSASTER SİTUATİONS THROUGH CULTURE & REFUGEE PARTİCİPATİON\n","ADAPAZARI 99 DEPREMİ SONRASI YAPILAŞMA SÜRECİNİN KENTE ETKİLERİ\n" +
            "EFFECTS OF RECONSTRUCTION PROCESS ON THE CITY AFTER ADAPAZARI 1999 EARTHQUAKE","DOĞA VE İNSAN İLİŞKİLERİ AÇISINDAN PORSUK NEHRİ KIYISINDA DEĞİŞİM/DÖNÜŞÜM/ÖZGÜNLÜK\n" +
            "CHANGE/TRANSFORMATİON/AUTHENTİCİTY İN THE BANKS OF PORSUK RİVER İN TERMS OF HUMAN-NATURE RELATİONS","SOSYAL-EKOLOJİK BİR SİSTEM OLARAK MAHALLE’ NİN MEKANSAL DİRENÇLİLİK BOYUTLARINI ÖRNEKLEM ÇALIŞMALARI YAKLAŞIMI ÜZERİNDEN ELE ALMAK\n" +
            "THE CASE STUDY APPROACH TO ADDRESS SPATIAL RESILIENCE DIMENSIONS OF NEIGHBORHOOD AS A SOCIAL-ECOLOGICAL SYSTEM",

            "TÜRKİYE’DE ÜÇ BOYUTLU BETON YAZICININ AZ KATLI KONUT YAPIMINDA KULLANILABİLİRLİĞİ VE KALIP UYGULAMA ÖNERİSİ\n" +
                    "APPLİCATİON OF THREE DİMENSİONAL CONCRETE PRİNTER İN LOW-RİSE HOUSİNG CONSTRUCTİON İN TURKEY AND USE OF CONCRETE FORMWORK PROPOSAL",
            "COĞRAFİ BİLGİ SİSTEMLERİ YARDIMIYLA YÜZEYSEL AKIŞIN RASYONEL METOTLA HESAPLANMASI\n" +
                    "CALCULATİON OF SURFACE FLOW WİTH RATİONAL METHOD USİNG GEOGRAPHİCAL INFORMATİON SYSTEMS",
            "ÇOK KRİTERLİ KARAR VERME MODELİ İLE BARAJ YERİ SEÇİMİNDE DEPREM FAY HATLARININ DİKKATE ALINMASI: YUKARI PORSUK HAVZASI ÖRNEĞİ\n" +
                    "CONSİDERATİON OF EARTHQUAKE FAULT LİNES İN SELECTİON OF DAM SİTE WİTH MULTİ CRİTERİA DECİSİON MODEL: CASE OF PORSUK BASİN",
            "YANMIŞ KİREMİT TOZU İLAVESİ İLE ZEMİN İYİLEŞTİRME ÇALIŞMASI\n" +
                    "SOIL IMPROVEMENT WITH ADDITION OF BURNT TILE DUST",
            ""
    };

    String[] oturum_baskan3 = {
            "HATİCE GÜNSELİ DEMİRKOL","HATİCE GÜNSELİ DEMİRKOL","HATİCE GÜNSELİ DEMİRKOL","HATİCE GÜNSELİ DEMİRKOL","HATİCE GÜNSELİ DEMİRKOL",

            "GÖKHAN AL","GÖKHAN AL","GÖKHAN AL","GÖKHAN AL","GÖKHAN AL"
    };

//for Salon 7
    String[] txt_title4 ={
            "AÇILIŞ SUNUMLARI","PINAR ACAR, ELİF YEŞİM KÖSTEN (10044)","RUMEYSA MELAN, BÜŞRA GÜDEN, HAKAN ARSLAN (9489)","FEYZA NUR IŞIK, ESRA MUTLU, HAKAN ARSLAN (9595)",
            "HAKAN ARSLAN, ALPER ÜNLÜ (9834)",

        "CENGİZ İPEK (9654)","ALİ POLAT, GÜLGÜN YILMAZ, NİHAT SİNAN IŞIK, EMRE AYTUĞ ÖZSÖY (9674)","ÜMİT KUT, NAZİLE URAL (9841)","YEŞİM ERBİL, BÜLENT TÜTMEZ (9954)",""
    };

    String[] txt_konu4 ={
            "","İZMİT MERKEZ KENTSEL KONUTUNDA MEKANSAL KİMLİK ve DEPREM RİSKİ İLİŞKİSİ: HAFIZ BİNBAŞI CADDESİ İNCELEMESİ\n" +
            "RELATION BETWEEN SPATIAL IDENTITY and EARTHQUAKE RISK IN CENTRAL IZMIT URBAN RESIDENCIALS: HAFIZ BINBASI STREET ANALYSIS","AFET SONRASI MODÜLER KONUT BİRİMİ TASARIMI İÇİN YENİLİKÇİ VE SİSTEMATİK BİR TASARIM YAKLAŞIM ÖNERİSİ\n" +
            "AN INNOVATIVE AND SYSTEMATIC APPROACH FOR POST DISASTER MODULAR HOUSING UNIT DESIGN\n","MİMARİ TASARIM STÜDYOSUNDA AFET SONRASI BARINMADA KULLANILABİLECEK STRATEJİLERİN KATILIMCI TASARIM YÖNTEMLERİ AÇISINDAN DEĞERLENDİRİLMESİ\n" +
            "ASSESSMENT OF POST DISASTER HOUSING STRATEGIES THROUGH PARTICIPATORY DESIGN METHODS USED IN ARCHITECTURAL DESIGN STUDIO\n","AFET SONRASI ADAPTASYON SÜRECİNİN ÇEVRESEL STRES,ALGI VE BİLİŞİM BAĞLAMLARINDA İNCELENMESİ\n" +
            "RESEARCH OF ENVİRONMENTAL STRESS, PERCEPTİON AND COGNİTİON İN THE CONTEXTS OF POST-DİSASTER ADAPTATİON PROCESS",

            "NANOMALZEMELERİN İNŞAAT ENDÜSTRİSİNDE KULLANIMININ ÖNEMİ\n" +
                    "THE İMPORTANCE OF USİNG OF NANOMATERİALS İN CONSTRUCTİON INDUSTRY\n",
            "ŞEV STABİLİTESİNDE SONLU ELEMANLAR YÖNTEMİNİN (STATİK VE DİNAMİK RİSKLER ALTINDA) UYGULAMASI-VAKA ANALİZİ\n" +
                    "APPLICATION OF FINITE ELEMENT METHOD IN SLOPE STABILITY (UNDER STATIC AND DYNAMIC RISKS): A CASE STUDY\n",
            "İNŞAAT ALANINDA KULLANILAN ATIK MALZEMELERİN DİNAMİK DAVRANIŞI\n" +
                    "DYNAMIC BEHAVIOR OF WASTE MATERIALS USED IN CIVIL ENGİNEERİNG\n",
            "KAYALARIN NOKTA YÜKLEME DİRENCİNİN AĞIRLIKLI ORTALAMAYLA DEĞERLENDİRİLMESİ\n" +
                    "EVALUATING POINT LOAD RESILIENCE OF ROCKS BASED ON WEIGHTED AVERAGING\n",
            ""
    };

    String[] oturum_baskan4 = {
            "ELİF YEŞİM KÖSTEN","ELİF YEŞİM KÖSTEN","ELİF YEŞİM KÖSTEN","ELİF YEŞİM KÖSTEN","ELİF YEŞİM KÖSTEN",

            "YEŞİM ERBİL","YEŞİM ERBİL","YEŞİM ERBİL","YEŞİM ERBİL","YEŞİM ERBİL"
    };

//for Salon 8
    String[] txt_title5 ={
            "AÇILIŞ SUNUMLARI","FEVZİYE DENİZ ATASAGUN, İFFET BİLLUR (9863)","RUBİN KARAKOYUNLU (9899)","FATMA HARAN, EMRE KİSHALI (9837)","NİLÜFER KIZILKAYA ÖKSÜZ, ALİ MURAT TANYER (9931)",

            "YASİN ZENCİR, GÜLGÜN YILMAZ, NİHAT SİNAN IŞIK, KAMİL BEKİR AFACAN (9669)","GÖKHAN ŞAHİN, GÜLGÜN YILMAZ, NİHAT SİNAN IŞIK, ERSİN GÜLER (9673)","RECEP BAKIŞ, YILDIRIM BAYAZIT, FATMA ÇİĞDEM ŞİRİN (9676)",
            "EKIN OZER (9880)","BİHTER DÖNMEZ (9587)"
    };

    String[] txt_konu5 ={
            "","KÜLTÜRÜ AFETLERDEN AŞIRMAK: KÜLTÜR VE TURİZM BAKANLIĞI HİBELERİNİN KÜLTÜR VARLIĞI SİVİL MİMARİ AÇISINDAN ÖNEMİ\n" +
                    "GETTING CULTURE THROUGH DISASTERS: IMPORTANCE OF RESTORASTİON GRANTS OF TURKİSH MİNİSTRY OF CULTURE AND TOURİSM FOR CİVİL HERİTAGE\n",
            "TARİHİ YAPILARDA SÜRDÜRÜLEBİLİRLİK VE PLANLI KORUMA BAĞLAMINDA MİMAR SİNAN ÇARŞI HAMAMI’NIN DEĞERLENDİRİLMESİ\n" +
                    "SUSTAİNABİLİTY İN HİSTORİCAL BUİLDİNGS AND EVALUATİON OF MİMAR SİNAN HAMMAM İN THE CONTEXT OF PLANNED PROTECTİON",
            "AFET ÜZERİNE BİR İNCELEME: “GÖÇ” VE BUNA DİRENEMEYEN “MAHKEMEAĞACİN”\n" +
                    "A RESEARCH ON DİSASTER:’’MIGRATION’’UNABLE TO RESİST “MAHKEMEAGACIN”",
            "YANGIN GÜVENLİĞİ İÇİN DİRENÇLİLİK\n" +
                    "RESİLİENCE FOR FİRE SAFETY\n",

            "STATİK VE DİNAMİK YÜKLER ALTINDA DESTEKLİ KAZI SİSTEMLERİNİN SONLU ELEMANLAR YÖNTEMİYLE PERFORMANSININ BELİRLENMESİ-VAKA ANALİZİ\n" +
                    "EVALUATION OF PERFORMANCE OF THE RETAINING SYSTEMS UNDER STATIC AND DYNAMIC LOADINGS BY FINITE ELEMENT METHOD: A CASE STUDY",
            "DEPREM RİSKİ ALTINDAKİ ZEMİNLERİN DİNAMİK DAVRANIŞININ SONLU ELEMANLAR YÖNTEMİ İLE ANALİZİ-ÖRNEK ÇALIŞMA\n" +
                    "ANALYSIS OF THE DYNAMIC BEHAVIOR OF SOILS IN EARTHQUAKE PRONE AREAS USING FINITE ELEMENT METHOD: A CASE STUDY",
            "AKIM GÖZLEM İSTASYONLARI ARASINDAKİ UZAKLIĞIN ALAN-ORANI METODUNA ETKİSİNİN İNCELENMESİ\n" +
                    "INVESTİGATİON OF THE EFFECT OF DİSTANCE BETWEEN FLOW OBSERVATİON STATİONS ON AREA-RATİO METHOD\n",
            "YAPİ SAGLİGİ TAKİP SİSTEMLERİNİN KOPRU DEPREM PERFORMANS DEGERLENDİRME SURECİNE ENTEGRASYONU\n" +
                    "INTEGRATİON OF STRUCTURAL HEALTH MONİTORİNG SYSTEMS İNTO BRİDGE SEİSMİC PERFORMANCE EVALUATİON",
            "İNŞAAT TEKNOLOJİSİNDE UYGULANMIŞ DEPREM İZOLATÖR SİSTEMLERİNİN İNCELENMESİ\n" +
                    "INVESTİGATİON OF EARTHQUAKE ISOLATOR SYSTEMS APPLİED İN CONSTRUCTİON TECHNOLOGY"
    };

    String[] oturum_baskan5 = {
            "EMRE KİSHALİ","EMRE KİSHALİ","EMRE KİSHALİ","EMRE KİSHALİ","EMRE KİSHALİ",

            "RECEP BAKIŞ","RECEP BAKIŞ","RECEP BAKIŞ","RECEP BAKIŞ","RECEP BAKIŞ"
    };
//for Salon 9
    String[] txt_title6 ={
            "AÇILIŞ SUNUMLARI","EREN BALABAN, ALES SMEJDA, MEHMET İNANC ONUR (9308)","HÜSEYİN BAYRAKTAR, ELİF SAHTİYANCI, ALİ KURU, BURCU YILMAZ BAYRAKTAR (9480)",
            "ASHFAQUE AHMED SOOMRO (9481)","AİSHA AL.OMAR (9888)",

            "ALİ UTKU ŞAHİN (9415)","RÜYA KAYA (9551)","MİNE NAZAN KERİMAK ÖNER (9668)","ARDA ŞORMAN, MUSTAFA CANSARAN ERTAŞ (10069)",""
    };

    String[] txt_konu6 ={
            "","FARKLİ DOLGU MALZEMESİNE SAHİP DONATİLİ ISTİNAD DUVARLARİNİN PERFORMANSLARİNİN DEGERLENDİRİLMESİ\n" +
            "PERFORMANCE ANALYSİS OF REİNFORCED EARTH WALLS WİTH DİFFERENT SOİLS",
            "OKULLARDA YAPISAL OLMAYAN ELEMANLARIN AFET KAYNAKLI OLASI RİSKLERİNİN L TİPİ MATRİS YÖNTEMİYLE BELİRLENMESİ\n" +
                    "DETERMINATION OF THE POSSIBLE RISKS OF DISASTER RESOURCES OF NON-STRUCTURAL ELEMENTS IN SCHOOLS BY L-TYPE MATRIX METHOD",
            "IDENTİFİCATİON AND PROMOTİON OF EFFECTİVE ADAPTATİON STRATEGİES İN THARPARKAR DESERT PAKİSTAN\n" +
                    "IDENTİFİCATİON AND PROMOTİON OF EFFECTİVE ADAPTATİON STRATEGİES İN THARPARKAR DESERT PAKİSTAN",
            "THE SPECİFİCATİONS OF APPLYİNG BUİLD-BACK-BETTER PROCESS İN THE NORTHWESTERN AREAS OF SYRİA TO FACİLİTATE THE REFUGEES’ RETURN\n" +
                    "THE SPECİFİCATİONS OF APPLYİNG BUİLD-BACK-BETTER PROCESS İN THE NORTHWESTERN AREAS OF SYRİA TO FACİLİTATE THE REFUGEES’ RETURN",

            "TÜRKİYE AFET MÜDAHALE PLANININ AFET YÖNETİMİ ve YÖNETİM BİLİMİ AÇISINDAN ANALİZİ\n" +
                    "ANALYSIS OF THE TURKEY’S NATIONAL DISASTER RESPONSE PLAN FROM THE POINT OF DISASTER MANAGEMENT AND ADMINISTRATIVE SCIENCES",
            "AFETE DİRENÇLİ ÖZEL SEKTÖR VE AFETE HAZIRLIKTA ÖRNEK BİR ÇALIŞMA: SAĞLAM KOBİ PROJESİ VE ÇIKTILARI\n" +
                    "DİSASTER RESİLİENT PRİVATE SECTOR AND BEST PRACTİCE İN DİSASTER PREPAREDNESS: SAGLAM KOBI PROJECT",
            "AFET SONRASI KENTSEL ORGANİK ATIK YÖNETİMİ\n" +
                    "MUNICIPAL ORGANIC SOLID WASTE MANAGEMENT AFTER DISASTER",
            "KAR İLE YAŞAMAYI ÖĞRENMEK\n" +
                    "LEARNİNG TO LİVE WİTH SNOW\n",
            ""
    };

    String[] oturum_baskan6 = {
            "ABDULLAH DİLSİZ","ABDULLAH DİLSİZ","ABDULLAH DİLSİZ","ABDULLAH DİLSİZ","ABDULLAH DİLSİZ",

            "MİNE NAZAN KERİMAK ÖNER","MİNE NAZAN KERİMAK ÖNER","MİNE NAZAN KERİMAK ÖNER","MİNE NAZAN KERİMAK ÖNER","MİNE NAZAN KERİMAK ÖNER"
    };
//for Salon 10
    String[] txt_title7 ={
            "AÇILIŞ SUNUMLARI","SEMRA KÖSE, HASAN TUTAR (10064)","NİMET KARAGÖZ, FATİH GÜLGEN, KEREM PEKER (10064)","ASHFAQUE AHMED SOOMRO (9481)","AİSHA AL.OMAR (9888)",

            "İSMAİL GÖKDAY (9662)","MURAT YAMAN, ERKAN ÇAKIR, OZAN YETKİN (9679)","BURAK YAPRAK, SELİM YAZICI (9906)","FAHRİ ÇAKI, ALPER UZUN, ABDURRAHMAN ÖZKAN (9982)",""

    };

    String[] txt_konu7 ={
            "","KRİZ DÖNEMLERİNDE BİLİŞSEL ESNEKLİĞİN ÖNEMİ ÜZERİNE BİR ARAŞTIRMA\n" +
            "A RESEARCH ON THE IMPORTANCE OF COGNITIVE FLEXIBILITY IN CRISIS PERIODS",
            "TÜRKİYE KAR BÖLGE VERİLERİNİN COĞRAFİ BİLGİ SİSTEMLERİ YARDIMIYLA AFET YÖNETİMİNDE KULLANILABİLİR ŞEKİLDE GÜNCELLENMESİ\n" +
                    "UPDATİNG OF TURKİSH SNOW ZONE DATA USED FOR DİSASTER MANAGEMENT BY GEOGRAPHİC İNFORMATİON SYSTEMS",
            "IDENTİFİCATİON AND PROMOTİON OF EFFECTİVE ADAPTATİON STRATEGİES İN THARPARKAR DESERT PAKİSTAN\n" +
                    "IDENTİFİCATİON AND PROMOTİON OF EFFECTİVE ADAPTATİON STRATEGİES İN THARPARKAR DESERT PAKİSTAN\n",
            "THE SPECİFİCATİONS OF APPLYİNG BUİLD-BACK-BETTER PROCESS İN THE NORTHWESTERN AREAS OF SYRİA TO FACİLİTATE THE REFUGEES’ RETURN\n" +
                    "THE SPECİFİCATİONS OF APPLYİNG BUİLD-BACK-BETTER PROCESS İN THE NORTHWESTERN AREAS OF SYRİA TO FACİLİTATE THE REFUGEES’ RETURN",

            "KENTSEL RİSK DEĞERLENDİRMESİ: ANTALYA KONSERVE KOYU ÖRNEĞİ\n" +
                    "URBAN RİSK ASSESSMENT: THE CASE OF ANTALYA KONSERVE COVE",
            "AFET YÖNETİMİNDE YEREL YÖNETİMLERİN YASAL VE KURUMSAL DURUMU: KÜTAHYA ÖRNEĞİ\n" +
                    "LEGAL AND INSTITUTIONAL POSITION OF LOCAL ADMINISTRATIONS ON DISASTER MANAGEMENT: CASE OF KÜTAHYA",
            "TÜRKİYE’DEKİ KOBİ’LERİN İŞ SÜREKLİLİĞİ YÖNETİMİ KONUSUNDAKİ FARKINDALIK DÜZEYLERİNİN BELİRLENMESİ\n" +
                    "DETERMİNİNG THE LEVEL OF BUSİNESS CONTİNUİTY MANAGEMENT AWARENESS OF SMES İN TURKEY",
            "DOĞAL AFETLERE HAZIRBULUNUŞLUKTA YEREL TOPLULUK LİDERLİĞİNİN SINIRLARI: MUHTARLAR ÜZERİNE BİR İNCELEME\n" +
                    "THE LIMITS OF LOCAL COMMUNITY LEADERSHIP IN NATURAL DISASTER PREPAREDNESS: A STUDY ON NAIGHBORHOOD HEADMEN",
            ""

    };

    String[] oturum_baskan7 = {
            "SEMRA KÖSE","SEMRA KÖSE","SEMRA KÖSE","SEMRA KÖSE","SEMRA KÖSE",

            "İSMAİL GÖKDAYI","İSMAİL GÖKDAYI","İSMAİL GÖKDAYI","İSMAİL GÖKDAYI","İSMAİL GÖKDAYI"
    };
//for Salon 11
    String[] txt_title8 ={
            "AÇILIŞ SUNUMLARI","ALİ TOLGA ÖZDEN, MELDA AÇMAZ ÖZDEN (9806)","ŞERİFE BETÜL ÇETİNKAYA, HİLAL ERKUŞ-ÖZTÜRK (9801)", "GİZEM KARACAN (9805)","",

             "ÖZGÜR OĞUZ (9401)","AHMET DOĞAN BAYGELDİ, SERPİL GERDAN (9681)","AYLA DEMİRAL, AYFER OLCAY (9712)","SİBEL ÇELİKEL YİĞİTER (9857)","İMRAN ASLAN (9983)"

    };

    String[] txt_konu8 ={
            "","DİRENÇLİ YAPILI ÇEVRE ÜRETİMİNDE SOSYO-MEKANSAL VE SOSYO-KÜLTÜREL ÖZELLİKLERİN ÖNEMİ: AYVACIK-ÇANAKKALE ÖRNEĞİ\n" +
            "IMPORTANCE OF SOCİO-SPATİAL AND SOCİO-CULTURAL CHARACTERİSTİCS İN PRODUCTİON OF RESİLİENT BUİLT ENVİRONMENT: AYVACIK-ÇANAKKALE EXAMPLE",
            "TARIM POLİTİKALARINDA DİRENÇLİLİK: KALKINMA PLANLARI ÜZERİNDEN BİR İNCELEME\n" +
                    "RESILIENCE IN AGRICULTURAL POLICIES: AN INVESTIGATION ON DEVELOPMENT PLANS\n",
            "KENTSEL PLANLAMADA İKLİM DİRENCİ TEMASI; ANKARA ÖRNEĞİ\n" +
                    "CLIMATE RESILIENCE THEME IN URBAN PLANNING; CASE OF ANKARA",
            "",

            "89/391 SAYILI AB DİREKTİFİNE GÖRE İŞVERENLERİN GENEL YÜKÜMLÜLÜKLERİ\n" +
                    "GENERAL OBLİGATİONS OF EMPLOYERS ACCORDİNG TO EU DİRECTİVE 89/391",
            "İŞ SAĞLIĞI VE GÜVENLİĞİ KAPSAMINDA ÖLÜMLÜ İŞ KAZALARINA YÖNELİK YARGITAY KARARLARI\n" +
                    "SUPREME COURT'S DECISIONS FOR DEATH WORK ACCIDENTS UNDER OCCUPATIONAL HEALTH AND SAFETY",
            "LABORATUVAR ORTAMLI FEN FAKÜLTELERİNDE İŞ SAĞLIĞI VE GÜVENLİĞİ FARKINDALIĞI\n" +
                    "OCCUPATIONAL HEALTH AND SAFETY AWARENESS IN LABORATORY ENVIRONMENT SCIENCE FACULTIES",
            "TEKNOLOJİK AFETLERİN ÖNLENMESİNDE İŞ SAĞLIĞI VE GÜVENLİĞİNİN ROLÜ\n" +
                    "THE ROLE OF OCCUPATİONAL HEALTH AND SAFETY İN THE PREVENTİON OF TECHNOLOGİCAL DİSASTERS",
            "BİNGÖL İLİNDEKİ ÖĞRETMENLERİN İŞ SAĞLIĞI VE GÜVENLİĞİ SEVİYESİNİN İNCELENMESİ\n" +
                    "INVESTIGATION OF OCCUPATIONAL HEALTH AND SAFETY LEVEL OF TEACHERS IN BİNGÖL PROVINCE"
    };

    String[] oturum_baskan8 = {
            "ALİ TOLGA ÖZDEN","ALİ TOLGA ÖZDEN","ALİ TOLGA ÖZDEN","ALİ TOLGA ÖZDEN","ALİ TOLGA ÖZDEN",

            "SİBEL ÇELİKEL YİĞİTER","SİBEL ÇELİKEL YİĞİTER","SİBEL ÇELİKEL YİĞİTER","SİBEL ÇELİKEL YİĞİTER","SİBEL ÇELİKEL YİĞİTER"
    };
//for Salon 12
    String[] txt_title9 ={
            "AÇILIŞ SUNUMLARI","EREN BALABAN, ALES SMEJDA, MEHMET İNANC ONUR (9308)","HÜSEYİN BAYRAKTAR, ELİF SAHTİYANCI, ALİ KURU, BURCU YILMAZ BAYRAKTAR (9480",
            "ASHFAQUE AHMED SOOMRO (9481)","AİSHA AL.OMAR (9888)",

        "","","","",""

    };

    String[] txt_konu9 ={
            "","FARKLİ DOLGU MALZEMESİNE SAHİP DONATİLİ ISTİNAD DUVARLARİNİN PERFORMANSLARİNİN DEGERLENDİRİLMESİ\n" +
            "PERFORMANCE ANALYSİS OF REİNFORCED EARTH WALLS WİTH DİFFERENT SOİLS",
            "OKULLARDA YAPISAL OLMAYAN ELEMANLARIN AFET KAYNAKLI OLASI RİSKLERİNİN L TİPİ MATRİS YÖNTEMİYLE BELİRLENMESİ\n" +
                    "DETERMINATION OF THE POSSIBLE RISKS OF DISASTER RESOURCES OF NON-STRUCTURAL ELEMENTS IN SCHOOLS BY L-TYPE MATRIX METHOD",
            "IDENTİFİCATİON AND PROMOTİON OF EFFECTİVE ADAPTATİON STRATEGİES İN THARPARKAR DESERT PAKİSTAN\n" +
                    "IDENTİFİCATİON AND PROMOTİON OF EFFECTİVE ADAPTATİON STRATEGİES İN THARPARKAR DESERT PAKİSTAN",
            "THE SPECİFİCATİONS OF APPLYİNG BUİLD-BACK-BETTER PROCESS İN THE NORTHWESTERN AREAS OF SYRİA TO FACİLİTATE THE REFUGEES’ RETURN\n" +
                    "THE SPECİFİCATİONS OF APPLYİNG BUİLD-BACK-BETTER PROCESS İN THE NORTHWESTERN AREAS OF SYRİA TO FACİLİTATE THE REFUGEES’ RETURN",

            "","","","",""
    };

    String[] oturum_baskan9 = {
            "MEHMET İNANÇ ONUR","MEHMET İNANÇ ONUR","MEHMET İNANÇ ONUR","MEHMET İNANÇ ONUR","MEHMET İNANÇ ONUR",

            "","","","",""
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        inflate = inflater.inflate(R.layout.fragment_tab1, container, false);

        btn1 = inflate.findViewById(R.id.btn1);
        btn2 = inflate.findViewById(R.id.btn2);
        btn3 = inflate.findViewById(R.id.btn3);
        btn4 = inflate.findViewById(R.id.btn4);
        btn5 = inflate.findViewById(R.id.btn5);
        btn6 = inflate.findViewById(R.id.btn6);
        btn7 = inflate.findViewById(R.id.btn7);
        btn8 = inflate.findViewById(R.id.btn8);
        btn9 = inflate.findViewById(R.id.btn9);
        title = inflate.findViewById(R.id.title_salon);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        Tab1Adapter tab1Adapter = new Tab1Adapter(getActivity(),txt_clock,txt_title,oturum_baskan);
        listView = inflate.findViewById(R.id.list_tab1);
        listView.setAdapter(tab1Adapter);

     //Default Selection Hall
        title.setText(getString(R.string.salon3));
        clilcked_btn = getString(R.string.salon3);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        go_details.putExtra("baskan",oturum_baskan9[position]);
                    }

                    startActivity(go_details);
                }else if(position == 1){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        go_details.putExtra("baskan",oturum_baskan9[position]);
                    }

                    startActivity(go_details);

                }else if(position == 2){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        go_details.putExtra("baskan",oturum_baskan9[position]);
                    }

                    startActivity(go_details);

                }else if(position == 3){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        go_details.putExtra("baskan",oturum_baskan9[position]);
                    }

                    startActivity(go_details);

                }else if(position == 4){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        go_details.putExtra("baskan",oturum_baskan9[position]);
                    }

                    startActivity(go_details);

                }else if(position == 5){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        go_details.putExtra("baskan",oturum_baskan9[position]);
                    }

                    startActivity(go_details);

                }else if(position == 6){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        go_details.putExtra("baskan",oturum_baskan9[position]);
                    }

                    startActivity(go_details);

                }else if(position == 7){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        go_details.putExtra("baskan",oturum_baskan9[position]);
                    }

                    startActivity(go_details);

                }else if(position == 8){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        go_details.putExtra("baskan",oturum_baskan9[position]);
                    }

                    startActivity(go_details);

                }else if(position == 9){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        go_details.putExtra("baskan",oturum_baskan9[position]);
                    }

                    startActivity(go_details);

                }
            }
        });

        return inflate;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){


            case R.id.btn1:
            //Salon 3
                title.setText(getString(R.string.salon3));
                clilcked_btn = getString(R.string.salon3);

                Tab1Adapter tab1Adapter = new Tab1Adapter(getActivity(),txt_clock,txt_title,oturum_baskan);
                listView = inflate.findViewById(R.id.list_tab1);
                listView.setAdapter(tab1Adapter);

                break;

            case R.id.btn2:
            //Salon 5
                title.setText(R.string.salon5);
                clilcked_btn = getString(R.string.salon5);

                Tab1Adapter tab1Adapter2 = new Tab1Adapter(getActivity(),txt_clock,txt_title2,oturum_baskan2);
                listView = inflate.findViewById(R.id.list_tab1);
                listView.setAdapter(tab1Adapter2);

                break;

            case R.id.btn3:
                //Salon 6
                title.setText(R.string.salon6);
                clilcked_btn = getString(R.string.salon6);

                Tab1Adapter tab1Adapter3 = new Tab1Adapter(getActivity(),txt_clock,txt_title3,oturum_baskan3);
                listView = inflate.findViewById(R.id.list_tab1);
                listView.setAdapter(tab1Adapter3);

                break;

            case R.id.btn4:
                //Salon 7
                title.setText(R.string.salon7);
                clilcked_btn = getString(R.string.salon7);

                Tab1Adapter tab1Adapter7 = new Tab1Adapter(getActivity(),txt_clock,txt_title4,oturum_baskan4);
                listView = inflate.findViewById(R.id.list_tab1);
                listView.setAdapter(tab1Adapter7);

                break;

            case R.id.btn5:
                //Salon 8
                title.setText(R.string.salon8);
                clilcked_btn = getString(R.string.salon8);

                Tab1Adapter tab1Adapter8 = new Tab1Adapter(getActivity(),txt_clock,txt_title5,oturum_baskan5);
                listView = inflate.findViewById(R.id.list_tab1);
                listView.setAdapter(tab1Adapter8);

                break;

            case R.id.btn6:
                //Salon 9
                title.setText(R.string.salon9);
                clilcked_btn = getString(R.string.salon9);

                Tab1Adapter tab1Adapter9 = new Tab1Adapter(getActivity(),txt_clock,txt_title6,oturum_baskan6);
                listView = inflate.findViewById(R.id.list_tab1);
                listView.setAdapter(tab1Adapter9);

                break;

            case R.id.btn7:
                //Salon 10
                title.setText(R.string.salon10);
                clilcked_btn = getString(R.string.salon10);

                Tab1Adapter tab1Adapter10 = new Tab1Adapter(getActivity(),txt_clock,txt_title7,oturum_baskan7);
                listView = inflate.findViewById(R.id.list_tab1);
                listView.setAdapter(tab1Adapter10);

                break;

            case R.id.btn8:
                //Salon 11
                title.setText(R.string.salon11);
                clilcked_btn = getString(R.string.salon11);

                Tab1Adapter tab1Adapter11 = new Tab1Adapter(getActivity(),txt_clock,txt_title8,oturum_baskan8);
                listView = inflate.findViewById(R.id.list_tab1);
                listView.setAdapter(tab1Adapter11);

                break;

            case R.id.btn9:
                //Salon 12
                title.setText(R.string.salon12);
                clilcked_btn = getString(R.string.salon12);

                Tab1Adapter tab1Adapter12 = new Tab1Adapter(getActivity(),txt_clock,txt_title9,oturum_baskan9);
                listView = inflate.findViewById(R.id.list_tab1);
                listView.setAdapter(tab1Adapter12);

                break;
        }
    }
}

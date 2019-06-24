package com.rota.kongresistem.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.rota.kongresistem.R;
import com.rota.kongresistem.activity.Details;
import com.rota.kongresistem.adapter.Tab1Adapter;


public class Tab2 extends Fragment implements View.OnClickListener {

    private View inflate;
    private ListView listView;
    private TextView title;
    private String clilcked_btn = "";
    private Button btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13;

    //for Salon 3
    private String[] txt_clock ={
            "14:00 - 14:20","14:20 - 14:40","14:40 - 15:00","15:00 - 15:20","15:20 - 15:40",

            "16:20 - 16:40","16:40 - 17:00","17:00 - 17:20","17:20 - 17:40","17:40 - 18:00","18:00 - 18:20"
    };

    private String[] txt_title  ={
            "KIVANÇ TAŞKIN, MELTEM VATAN KAPTAN, AHMET KAPTAN, KEREM PEKER (10066)","NİMET KARAGÖZ, FATİH GÜLGEN, KIVANÇ TAŞKIN, KEREM PEKER (10067)","MİTHAT EKİCİ (10120)","ERCAN BÜYÜKBAŞ (10142)","Serhat ŞENSOY, Yılmaz AÇAR, M. Gökhan BEKAROĞLU, Mustafa YILDIRIM, Mustafa ATILAN, Serhat ÖZYILDIRIM",

            "M.AYHAN ERKAN, AYSEL SERAP AKGÜNDÜZ, HÜSEYİN ARABACI, ERDEM ODABAŞI, MURAT SOYDAM (9686)","BARIŞ ÖZGÜN, EMEL ÜNAL (9711)","KAAN EMİR, BERİL ALPAGUT (9761)","AYŞE ÇAĞLAYAN, SAMİ ERCAN, MUSTAFA AKTAN, ESRA EZGİ BAKSI, EYÜP ÇİMENTEPE, SALİH KARAKISA, HAMİDE BAŞER ERGÖZ (9797)",
            "CİHAN DÜNDAR, NEZAHAT ÖZ, İSAMEDDİN OMAK, MUSTAFA SERT (9842)","CİHAN DÜNDAR, AYŞE GÖKÇEN IŞIK, GÜLEN GÜLLÜ (9843)"

    };

    private String[] txt_konu = {"EKSTREM METEOROLOJİK OLAYLARIN DÖNÜŞ ARALIKLARI VE DİRENÇLİLİK İLİŞKİSİ\n" +
            "RETURN PERİODS OF EXTREME METEOROLOGİCAL EVENTS AND RESİLİENCE RELATİONS","COĞRAFİ BİLGİ SİSTEMLERİNİN METEOROLOJİK EKSTREM DEĞER DAĞILIMLARININ DEĞERLENDİRİLMESİNDE VE AFET YÖNETİMİNDE KULLANIMI\n" +
            "USE OF GEOGRAPHİC İNFORMATİON SYSTEMS İN EVALUATİON OF METEOROLOGİCAL EXTREME VALUE DİSTRİBUTİONS AND DİSASTER MANAGEMENT","İKLİM DEĞİŞİKLİĞİNE DİRENÇ ADINA İYİ BİR ÖRNEK: OZON TABAKASINI KORUMA PROTOKOLÜ VE DEĞİŞİKLİKLERİ\n" +
            "A GOOD EXAMPLE FOR RESILIENCE TO CLIMATE CHANGE: PROTOCOL AND CHANGES OF OZONE LAYER PROTECTION","RİSK AZALTMA VE DİRENÇLİLİK SÜRECİNDE METEOROLOJİNİN FARKINDALIĞI VE KATKISI ÜZERİNE BİR DEĞERLENDİRME\n" +
            "AN ASSESSMENT ON THE AWARENESS AND CONTRİBUTİON OF THE METEOROLOGY İN THE RİSK REDUCTİON AND RESİLİENCE PROCESS","Meteoroloji Genel Müdürlüğü’nde İş Sağlığı Güvenliği Uygulamaları Occupational Health and Safety Applications in Turkish State Meteorological Service",

            "METEOROLOJİK KARAKTERLİ DOĞAL AFETLERİN 2018 YILI DEĞERLENDİRMESİ\n" +
                    "METEOROLOGİCAL DİSASTERS ASSESSMENT İN 2018 YEAR\n","METEOROLOJİK ERKEN UYARI SİSTEMLERİ VE AFET DİRENÇLİLİĞİNDEKİ ROLÜ\n" +
            "METEOROLOGİCAL EARLY WARNİNG SYSTEMS AND ROLE ON DİSASTER RESİLİENCE\n","İKLİM DEĞİŞİKLİĞİ İLE MÜCADELEDE YEŞİL ALTYAPI VE DOĞA ESASLI ÇÖZÜMLER\n" +
            "FİGHT AGAİNST CLİMATE CHANGE WİTH GREEN INFRASTRUCTURE INTERVENTİONS AND NATURE BASED SOLUTİONS\n","YAPAY MAĞARA ALANLARININ MİKROBÖLGELEME ÇALIŞMALARI İLE BELİRLENMESİNE BİR ÖRNEK: GAZİANTEP İLİ, ŞEHİTKAMİL İLÇESİ (TÜRKİYE)\n" +
            "DETERMİNATİON OF UNNATURAL CAVE SİTES BY MİCROZONATİON STUDİES: A CASE STUDY OF ŞEHİTKAMİL DİSTRİCT, GAZİANTEP PROVİNCE, TURKEY","TÜRKİYE’DE 2007-2018 YILLARI ARASINDA YAŞANAN ENVERZİYON OLAYLARININ ALANSAL VE ZAMANSAL DEĞİŞİMİNİN İNCELENMESİ\n" +
            "INVESTİGATİON OF THE TEMPERATURE INVERSİONS BETWEEN THE YEARS OF 2007-2018 İN TURKEY.","2018 YILINDA TÜRKİYE’DE GERÇEKLEŞEN KUVVETLİ VE EKSTREM AEROSOL OLAYLARININ 2005-2018 DÖNEMİ İLE BİRLİKTE ANALİZİ\n" +
            "ANALYSIS OF THE STRONG AND EXTREME AEROSOL EVENTS IN TURKEY BETWEEN 2005-2018"

    };

    private String[] oturum_baskan = {
            "ERCAN BÜYÜKBAŞ","ERCAN BÜYÜKBAŞ","ERCAN BÜYÜKBAŞ","ERCAN BÜYÜKBAŞ","",

            "CİHAN DÜNDAR","CİHAN DÜNDAR","CİHAN DÜNDAR","CİHAN DÜNDAR","CİHAN DÜNDAR","CİHAN DÜNDAR"

    };

//for Salon 4
    private String[] txt_title14  ={
            "SEÇKİN FİDAN, TOLGA GÖRÜM (9773", "REMZİ POLAT, ZEYNEP COŞKUN, OĞUZ ÖZEL, NURCAN M. ÖZEL, YOSHİYUKİ KANEDA, HALUK ÖZENER (9746)","AYCAN GÜNAY, AYŞE ÇAĞLAYAN, REZA SABER, VEYSEL IŞIK (9802)","SHAGHAYEGH KARIMZADEH, AYŞEGÜL ASKAN (9958)","",

        "ERHAN GÜMÜŞ, MUSTAFA KEMAL VARÇİN, ALİ ERHAN YILMAZ, SERDAR CENİKLİ (10078) ","ONUR KAPLAN, YÜCEL GÜNEY, MUAMMER TÜN (10086)","ALİ ERHAN YILMAZ, MUSTAFA KEMAL VARÇİN, ERHAN GÜMÜŞ, SERDAR CENİKLİ (10101)",
        "SARP DİNCER, EREN AYDIN, HİMMET GENCER, ERENCAN TAYANÇ (10107)","GÜRKAN YILMAZ (9846)","GÜRKAN YILMAZ (9852)"
    };

    private String[] txt_konu14 = {
            "TÜRKİYE ÖLÜMCÜL HEYELAN ARŞİV ENVANTERİ (1929-2018)\n" +
                    "FATAL LANDSLIDE ARCHIVE INVENTORY OF TURKEY FROM 1929 TO 2018\n" + "DOĞAN KALAFAT, Yojiro YAMAMOTO, Ali PINARul), Narumi TAKAHASHI, Seçkin ÇITAK, Motoyuki KIDO, Ryusuke YAMAMOTO, MUSTAFA KEMAL TUNCER,","MARMARA DENİZİ’NDE DEPREM RİSKİNİN BELİRLENMESİNE YÖNELİK SON YILLARDA YAPILAN ÇALIŞMALARA BİR BAKIŞ\n" +
            "A REVİEW OF RECENT STUDİES TO DETERMİNE EARTHQUAKE RİSK İN THE MARMARA SEA","SINDIRGI-SİNANPAŞA FAY ZONUNDA SİMAV ALT ZONUNUN TEKTONİK AKTİVİTE GÖSTERGELERİ VE AFET RİSKİ, BATI ANADOLU\n" +
            "TECTONİC ACTİVİTY INDİCATORS AND DİSASTER RİSK OF SİMAV SUB-ZONE İN SINDIRGI-SİNANPAŞA FAULT ZONE, WESTERN ANATOLİA","1939 ERZİNCAN DEPREMİNİN SAYISAL OLARAK MODELLENMESİ\n" +
            "NUMERİCAL MODELİNG OF THE 1939 ERZİNCAN EARTHQUAKE\n","",

            "RİSKLİ YAPILARIN TESPİT EDİLMESİNE İLİŞKİN ESASLAR UYARINCA RİSKLİ YAPI TESPİTİ YAPILAN BİNALARIN SAYISAL ANALİZ SONUÇLARININ DEĞERLENDİRİLMESİ\n" +
                    "EVALUATİON OF NUMERİCAL ANALYSİS RESULTS OF THE BUİLDİNGS BEİNG CARRİED OUT SEİSMİC RİSK EVALUATİON IN ACCORDANCE WİTH THE PRİNCİPLES\n" +
                    "FOR SEİSMİC RİSK EVALUATİON OF EXİSTİNG BUİLDİNGS","ESKİŞEHİR KENT MERKEZİ BİNA ENVANTERİNİN OLUŞTURULMASI PİLOT ÇALIŞMASI\n" +
            "ESTABLISHING ESKISEHIR BUILDING INVENTORY DATABASE: A PILOT STUDY","RİSKLİ YAPILARIN TESPİT EDİLMESİNE İLİŞKİN ESASLAR 2013 VE 2019’UN BETONARME BİNALAR İÇİN KARŞILAŞTIRILMASI\n" +
            "COMPARISON OF PRINCIPLES FOR SEISMIC RISK EVALUATION OF EXISTING BUILDINGS 2013 AND 2019 IN TERMS OF RC BUILDINGS","BİR KARAR DESTEK SİSTEMİ OLARAK YAPI SAĞLIĞI İZLEME MERKEZİ ALTYAPISI ÇÖZÜMÜ\n" +
            "STRUCTURAL HEALTH MONİTORİNG CENTER SUBSTRUCTURE SOLUTİON AS A DECİSİON SUPPORT TOOL","ARTVİN HOPA SEL AFETİNİN AFET YÖNETİMİ AÇISINDAN ETKİNLİĞİNİN DEĞERLENDİRİLMESİ\n" +
            "EVALUATION OF THE FLOOD IN ARTVIN'S DISTRICT OF HOPA IN TERMS OF DISASTER MANAGEMENT","AFETLER VE GIDA GÜVENLİĞİ İLİŞKİSİ\n" +
            "RELATIONSHIP OF DISASTERS AND FOOD SAFETY"

    };

    private String[] oturum_baskan14 = {
            "AYŞEGÜL AŞKAN","AYŞEGÜL AŞKAN","AYŞEGÜL AŞKAN","AYŞEGÜL AŞKAN","",

            "ONUR KAPLAN","ONUR KAPLAN","ONUR KAPLAN","ONUR KAPLAN","ONUR KAPLAN","ONUR KAPLAN"

    };

//for Salon 5
    private String[] txt_title2  ={
            "ZEYNEP GÜREL (9435)","SERPİL GERDAN, ESMA BULUŞ KIRIKKAYA (9625)","JALE YAZGAN (9850)","SEVDA DEMİRÖZ YILDIRIM (9879)","",

            "CANGUL KUS (9488)","MELİS ERDENER (9867)","SUTAY YAVUZ (9833)","","",""
     };

    private String[] txt_konu2 = {
            "AFETLERE HAZIRLIK SÜRECİNDE ÜNİVERSİTE ÖĞENCİLERİNİN YAŞAM DENEYİMLERİNDE DİRENÇLİLİK\n" +
                    "THE CONCURRİNG RESİLİENT LİVED EXPERİENCES OF UNİVERSİTY STUDENTS WİTHİN THE PREPARATİON PROCESS OF DİSASTERS",
            "SİVİL SAVUNMA VE İTFAİYECİLİK PROGRAMI ÖĞRENCİLERİNİN AFET FARKINDALIĞI, AFET-İTFAİYECİLİK İLİŞKİSİ VE TÜRKİYE’DEKİ AFET ÇALIŞMALARINA YÖNELİK GÖRÜŞLERİ\n" +
            "THE DISASTER AWARENESS OF CIVIL DEFENSE AND FIREFIGHTING PROGRAM STUDENTS,\n" +
            "OPINIONS ON RELATION BETWEEN DISASTER AND FIREFIGHTING PROFESSION AND DISASTER STUDIES IN TURKEY","Acil Durum ve Afet Yönetimi Önlisans Programlarının Karşılaştırılması Comparison of Emergency and Disaster Management Associate Degree Programs",
            "Hastane Öncesi Acil Sağlık Hizmetlerinde Olay Yeri Triaj Yönetimi Field Triage Management in Prehospital Emergency Health Services","",

            "AFET DİRENCİNİN GELİŞTİRİLMESİNDE YOKSULLUKLA MÜCADELE: BİR POLİTİKA ARACI OLARAK KALKINMA AJANSLARI COMBATING AGAINST POVERTY FOR DISASTER RESILIENCE: REGIONAL DEVELOPMENT AGENCIES AS A POLICY TOOL","AFET ÇALIŞANLARINDA PSİKOLOJİK DAYANIKLILIK VE İKİNCİL TRAVMATİK STRES PSYCHOLOGICAL RESILIENCE AND SECONDARY TRAUMATİC STRESS IN DISASTER WORKER",
            "Afete Karşı Dirençliliği Geliştirmede Dikkat Edilmesi Gereken Yeni Bir Sosyal Grup: Yalnız Yaşayan Yaşlılar An emerging social group that needs to be paid attention for disaster resilience: Old age individuals living alone","","",""

    };

    private String[] oturum_baskan2 = {
            " SERPİL GERDAN"," SERPİL GERDAN"," SERPİL GERDAN"," SERPİL GERDAN","",

            "SUTAY YAVUZ","SUTAY YAVUZ","SUTAY YAVUZ","SUTAY YAVUZ","",""

    };

//for Salon 6
    private String[] txt_title3  ={
            "HİCRAN HANIM HALAÇ, HALİL İBRAHİM KARAGÖ (10022)","HİCRAN HANIM HALAÇ, HALİL İBRAHİM KARAGÖZ (10024)","HİCRAN HANIM HALAÇ, SAADET TURAN (10088)","FATMA HARAN, EMRE KİSHALI (9837)","",

            "MARUF ARAS, AHMET MURAT ÖZALTIN, MUSTAFA BERK DUYGU, ALPER DİNÇER (9776)","EFNAN ŞORA GÜNAL, UĞUR GÜREL (9822)","VAHAP TECİM (9902)","HACI AHMET KIRTAŞ, HÜSEYİN ALTUNDAĞ (9789)",
            "",""
    };

    private String[] txt_konu3 = {
            "MİMARİ KORUMA KAPSAMINDA PERGE AĞALAR CAMİNDEKİ ZEMİN GÜÇLENDİRME ÇALIŞMASINA YÖNELİK DEĞERLENDİRME\n" +
                    "EVALUATİON OF THE GROUND STRENGTHENİNG STUDY İN PERGE AĞALAR MOSQUE GROUND ARCHİTECTURAL PROTECTİON","DEPREM AFETİNE YÖNELİK TARİHİ YAPILARDAKİ SAĞLIKLAŞTIRMA YÖNTEMLERİNİN İRDELENMESİ\n" +
            "INVESTİGATİON OF RESTORATİON METHODS İN HİSTORİCAL BUİLDİNGS FOR EARTHQUAKE DİSASTER","TARİHİ KÖPRÜLERİN SU BASKINLARINDAKİ DURUMLARININ DEĞERLENDİRİLMESİ\n" +
            "EVALUATION OF THE STATUS OF HISTORICAL BRIDGES IN WATER FLOWS\n","Afet Üzerine Bir İnceleme: “GÖÇ” ve Buna Direnemeyen “MAHKEMEAĞACİN” A Research on Disaster:’’MIGRATION’’Unable to Resist “MAHKEMEAGACIN”","",

            "CBS TABANLI HAVZA KURAKLIK BİLGİ VE ERKEN UYARI SİSTEMİ\n" +
                    "GIS BASED BASIN DROUGHT INFORMATION AND EARLY WARNİNG SYSTEM","VERİ MADENCİLİĞİ VE MAKİNE ÖĞRENMESİ YÖNTEMLERİ KULLANILARAK ORMAN YANGINLARININ ERKEN TESPİTİ\n" +
            "EARLY DETECTİON OF FOREST FİRES USİNG DATA MİNİNG AND MACHİNE LEARNİNG METHODS","AFET YÖNETİMİNDE YENİ NESİL TEKNOLOJİLER\n" +
            "THE EMERGING OF NEW GENERATION TECHNOLOGIES IN DISASTER MANAGEMENT","İTFAİYE TEŞKİLATLARINDA HABERLEŞME\n" +
            "COMMUNICATION IN FIRE ORGANIZATIONS","",""

    };

    private String[] oturum_baskan3 = {
            "EMRE KİSHALİ","EMRE KİSHALİ","EMRE KİSHALİ","EMRE KİSHALİ","",

            "VAHAP TECİM","VAHAP TECİM","VAHAP TECİM","VAHAP TECİM","VAHAP TECİM",""

    };

//for Salon 7
    private String[] txt_title4  ={
            "GÜLHAN ŞEN, ELÇİN ÇEVİKBAŞ (9764)","ÖZLEM ÇAKIR (9765)","YILDIZ ULUSOY, OSMAN NEJAT AKFIRAT, BERNA GÜL (9781)","HACI AHMET KIRTAŞ, HÜSEYİN ALTUNDAĞ (9787)","",

            "GÜLHAN ŞEN, SAKİNE ERDEM (9707)","SEVDA DEMİRÖZ YILDIRIM (9738)","GALİP USTA, KEMAL TORPUŞ, UÇAR KÜÇÜK (9813)","BÜLENT ÖZMEN, MUAMMER TÜN (9826)",
        "RUKİYE ÇETİN, SALAH HAJ ISMAIL, ABDULLAH DİLSİZ (9932)","BÜLENT COŞKUN (10162)"
    };

    private String[] txt_konu4 = {
            "ÖZEL GEREKSİNİMLİ VE NORMAL GELİŞİM GÖSTEREN ÇOCUKLARA YÖNELİK AFET BİLİNCİ EĞİTİMİ: YARATICI DRAMA YÖNTEMİ\n" +
                    "DISASTER AWARENESS TRAINING FOR CHILDREN WITH SPECIAL NEEDS AND NORMAL DEVELOPMENT: CREATIVE DRAMA METHOD","KADERCİLİK EĞİLİMİ İLE AFET TUTUMU ARASINDAKİ İLİŞKİYE YÖNELİK AMPİRİK BİR ARAŞTIRMA\n" +
            "AN AMPIRICAL RESEARCH ABOUT THE RELATIONSHIP BETWEEN THE FATALISM TENDENCY AND DISASTER ATTITUDE","PSİKOLOJİK DANIŞMANLARIN GÖZLEMLERİNE GÖRE SURİYELİ GÖÇMEN ÇOCUKLAR\n" +
            "SYRİAN REFUGEE CHİLDREN ACCORDİNG TO THE OBSERVATİONS OF PSYCHOLOGİCAL COUNSELORS","ACİL DURUM VE AFET YÖNETİMİ PERSONELİNİN ÖZEL GEREKSİNİMLİ BİREY EĞİTİMİ\n" +
            "SPECIAL REQUIREMENT OF EMERGENCY AND DISASTER MANAGEMENT PERSONNELINDIVIDUAL EDUCATION","",

            "ACİL YARDIM VE AFET YÖNETİMİ ÖĞRENCİLERİNİN İKLİM DEĞİŞİKLİĞİNE YÖNELİK TUTUMLARININ DEĞERLENDİRİLMESİ:\n" +
                    "BURDUR MEHMET AKİF ERSOY ÜNİVERSİTESİ ÖRNEĞİ\n" +
                    "EVALUATİON OF THE ATTİTUDES OF EMERGENCY AİD AND DİSASTER MANAGEMENT STUDENTS TOWARDS CLİMATE CHANGE:\n" +
                    "EXAMPLE OF BURDUR MEHMET AKİF ERSOY UNİVERSİTY","AMASYA ÜNİVERSİTESİ SABUNCUOĞLU ŞEREFEDDİN SAĞLIK HİZMETLERİ MESLEK YÜKSEKOKULU ÖĞRENCİLERİNİN TEMEL AFET BİLİNÇ DÜZEYLERİNİN DEĞERLENDİRİLMESİ\n" +
            "EVALUTION OF THE BASIC DISASTER AWARENESS LEVELS OF STUDENTS OF AMASYA UNIVERSITY SABUNCUOĞLU ŞEREFEDDİN HEALTH SERVICES VOCATIONAL SCHOOL\n","MESLEK YÜKSEKOKULUNDA OKUYAN ÖĞRENCİLERİN DEPREM BİLGİ DÜZEYİNİN DEĞERLENDİRİLMESİ\n" +
            "EVALUATION OF EARTHQUAKE KNOWLEDGE LEVELS OF THE VOCATIONAL SCHOOL STUDENTS","TÜRKİYE’DEKİ ACİL YARDIM VE AFET YÖNETİMİ LİSANS PROGRAMLARININ İNCELENMESİ\n" +
            "INVESTIGATION OF EMERGENCY AID AND DISASTER MANAGEMENT DEGREE PROGRAMS IN TURKEY\n","“AFET VE SAVAŞ SONRASI İMAR VE REHABİLİTASYON” DİSİPLİNLERARASI YÜKSEK LİSANS PROGRAMININ KURULMASI\n" +
            "ESTABLİSHMENT OF INTERDİSCİPLİNARY MASTER PROGRAM ON “POST-DİSASTER AND POST-WAR RECONSTRUCTİON AND REHABİLİTATİON”\n","BİR DOĞAL AFET SONRASI KAYDEDİLMİŞ VİDEOLARIN EĞİTİM ARACI OLARAK KULLANILMASI\n" +
            "UTİLİZATİON OF VİDEO RECORDED EXPERİENCES AFTER A NATURAL DİSASTER AS A TOOL FOR EDUCATİON"
    };

    private String[] oturum_baskan4 = {
            "YILDIZ ULUSOY","YILDIZ ULUSOY","YILDIZ ULUSOY","YILDIZ ULUSOY","",

            "BÜLENT ÖZMEN","BÜLENT ÖZMEN","BÜLENT ÖZMEN","BÜLENT ÖZMEN","BÜLENT ÖZMEN","BÜLENT ÖZMEN"
    };

//for Salon 8
    private String[] txt_title5 ={
            "MERYEM ABOUSHALA, ABDULLAH DİLSİZ (9883)","SEZER AVCI (9839)","ZEHRA BAŞHAN (9865)","NEVİN ÖZDEMİR, İLYAS KARA (9903)","",

            "ESİN GÜRSEL (9499)","YELİZ ŞANLI ATAY (9685)","ŞERİFE YILDIZ AKGÜL (9872)","ÖZGE OKAY TEKİNSOY (9886)","ILGIN ÖZKAYA ÖZLÜER (9904)",""
    };

    private String[] txt_konu5 = {
            "İlkokullarda Erken Uyarı Sistemleri: Entegrasyon ve Uygulama Early Warning Systems in Primary Schools: Integration and Implementation","Hemşirelik bölümündeki öğrencilerin afet konusundaki bilgi ve bilinç düzeyleri The level of knowledge and awareness of nursing students about disasters",
             "İlk Yardım Eğitimi Alan Bireylerin İlk Yardıma İlişkin Öz- Yeterlik Düzeylerinin İncelenmesi The Examination of First Aid Self-Efficacy in Individuals with First Aid Training","ERBAA, NİKSAR VE TAŞOVA ÖRNEKLEMİNDE 8. SINIF ÖĞRENCİLERİNİN AFET KORUYUCU DAVRANIŞ BİLGİLERİNİN DEĞERLENDİRİLMESİ\n" +
            "EVALUATİON OF THE RESPONSE-RELATED PROTECTİVE BEHAVİOUR İNFORMATİON OF 8TH GRADE STUDENTS ON THE BASİS OF ERBAA, NİKSAR AND TAŞOVA SAMPLE","",

            "YAPI KAYIT BELGESİNİN HUKUKİ NİTELİĞİ VE İMAR MEVZUATINA AYKIRI YAPI ÜZERİNDEKİ HUKUKİ SONUÇLARI\n" +
                    "BUILDING REGISTRATION CERTIFICATE AND LEGAL RESULTS ABOUT THE BUILDING","AFETLER VE İDARENİN HUKUKİ SORUMLULUĞU\n" +
            "DISASTERS AND LEGAL RESPONSİBİLİTY OF ADMİNİSTRATION","DEPREM VE MÜLKİYET HAKKI\n" +
            "EARTHQUAKE AND PROPERTY RİGHT","TABİİ AFETLERDE İDARENİN SORUMLULUĞU\n" +
            "RESPONSIBILITY OF ADMINISTRATION FROM NATURAL DISASTERS","HABİTAT 3 YENİ KENTSEL GÜNDEM PROGRAMI BAĞLAMINDA İKLİM DEĞİŞİKLİĞİNE BAĞLI AFETLERE KARŞI YEREL YÖNETİMLERİN ROLÜ\n" +
            "THE ROLE OF LOCAL ADMİNİSTRATİONS AGAİNST NATURAL DİSASTERS IN THE CONTEXT OF HABİTAT 3 NEW URBAN AGENDA PROGRAM",""
    };

    private String[] oturum_baskan5 = {
            "ABDULLAH DİLSİZ","ABDULLAH DİLSİZ","ABDULLAH DİLSİZ","ABDULLAH DİLSİZ","",

            "YELİZ ŞANLI ATAY","YELİZ ŞANLI ATAY","YELİZ ŞANLI ATAY","YELİZ ŞANLI ATAY","YELİZ ŞANLI ATAY",""
    };

//for Salon 9
    private String[] txt_title6 ={
            "MELİKE POLAT, MERVE MERYEM GÜRLEVİK, EZGİ TOPDAĞI, SÜLEYMAN TOY (9683)","BİRGÜL ESMERAY, MEDİNE ÇELİK, SÜLEYMAN TOY (9609)","BURCU ADIGÜZEL, FERDA KAYA, MUKADDES MERVE AKYAR, SÜLEYMAN TOY (9614)",
            "BÜŞRA KADIOĞLU, YELDA GAMZE YALÇINER, SÜLEYMAN TOY (9604)","",

            "M. ANIL ŞENYEL (9815)","ADNAN KAPLAN (9901)","SAVAŞ ÇAĞLAK, SÜLEYMAN TOY (9786)","SAVAŞ ÇAĞLAK, SÜLEYMAN TOY (9786)","",""
    };

    private String[] txt_konu6 = {
            "GELENEKSEL MİMARİ VE KENT DOKUSUNDA BİYOKLİMATİK KONFOR DUYARLI UYGULAMALAR\n" +
                    "BİOCLİMATİC COMFORT – SENSİTİVE PRACTİCES İN TRADİTİONAL ARCHİTECTURE AN URBAN STRUCTURE","KENT KANYONLARININ KENTSEL YAŞAM ALANLARINA OLUMSUZ ETKİLERİ VE PEYZAJ TASARIM ÇALIŞMALARI KAPSAMINDA ALINACAK ÖNLEMLER; ERZURUM KENT\n" +
            "MERKEZİNDEN BİR ÖRNEK\n" +
            "THE NEGATİVE EFFECTS OF THE URBAN CANYONS TO URBAN AREAS AND MEASURES TO BE TAKEN İN THE SCOPE OF LANDSCAPE DESİGN;\n" +
            "AN EXAMPLE FROM ERZURUM CİTY CENTRE","(BİYO)İKLİM DUYARLI KENTSEL TASARIM İLKELERİNİN KIŞ KENTİ ERZURUM İÇİN BELİRLENMESİ\n" +
            "DETERMİNATİON OF BİO-CLİMATE SENSİTİVE URBAN DESİGN PRİNCİPLES FOR THE WİNTER CİTY ERZURUM","BİNA ORYANTASYONUNUN KENT SAKİNLERİNİN DIŞ MEKAN KULLANIMINA ETKİSİNİN ERZURUM PALANDÖKEN İLÇESİNDE BELİRLENMESİ\n" +
            "DETERMİNATİON OF THE EFFECTS OF THE BUİLDİNG ORİENTATİON ON CİTY DWELLERS’ USE OF OUTDOOR İN PALANDÖKEN DİSTRİCT OF ERZURUM CİTY","",

            "Türkiye’de Hava Kirliliği’nin Mekansal Yayılımının Modellenmesi ve Görselleştirilmesi Modelling and Visualizing Spatial Distribution of Air Pollution in Turkey",
            "Resilient kıyı için peyzaj temelli pratikte paradigma değişimi Paradigm shift in landscape-based practice for coastal resilience",
            "Konya’nın Turizm Faaliyetleri Açısından Biyoklimatolojisi Bioclimatology of Konya, a Turkish culture tourism city, for touristic activities",
            "Konya’nın Turizm Faaliyetleri Açısından Biyoklimatolojisi Bioclimatology of Konya, a Turkish culture tourism city, for touristic activities",
            "",""

    };

    private String[] oturum_baskan6 = {
            "SÜLEYMAN TOY","SÜLEYMAN TOY","SÜLEYMAN TOY","SÜLEYMAN TOY","",

            "SÜLEYMAN TOY","SÜLEYMAN TOY","SÜLEYMAN TOY","SÜLEYMAN TOY","SÜLEYMAN TOY","SÜLEYMAN TOY"
    };

//for Salon 10
    private String[] txt_title7 ={
            "TARIK İLHAN (8836)","EDA SELİMOĞLU, TİMUR GÜLTEKİN, NEHİR VAROL (9660)","AYŞE PINAR ULUÇAY, SELİM YAZICI (9807)","LEYLA AFŞAR DOĞRUSÖZ, SELİM YAZICI (9921)","",

            "ABDURAHMAN YASİN YİĞİT, MURAT UYSAL (10075)","İBRAHİM AYTAŞ, BURHAN ACET, UMUT PEKİN TİMUR, ÖZGÜR BURHAN TİMUR (10084)","MURAT UYSAL, ABDULLAH VARLIK (10089)",
            "SERTAÇ TUHTA, FURKAN GÜNDAY, HAKAN AYDIN, ÇAĞLA PEHLİVAN (10132)","SERTAÇ TUHTA, FURKAN GÜNDAY, HAKAN AYDIN, ÇAĞLA PEHLİVAN (10133)","DENİZ GERÇEK KURT, İSMAİL TALİH GÜVEN (10191)"
    };

    private String[] txt_konu7 = {
            "DOĞAL AFETLERİN YARATTIĞI NEGATİF EKONOMİK ETKİLERİN AZALTILMASINDA UYGULANABİLECEK FİNANSAL YÖNTEMLER\n" +
                    "FINANCIAL METHODS APPLIED TO REDUCE THE NEGATIVE ECONOMIC EFFECTS OF NATURAL DISASTERS","AFETLERİN TURİZM SEKTÖRÜNE ETKİSİ\n" +
            "THE EFFECTs OF DISASTERS ON THE TOURISM SECTOR","SİGORTA SEKTÖRÜNDE İŞ SÜREKLİLİĞİ YÖNETİMİ: GÜNEŞ SİGORTA ÖRNEĞİ\n" +
            "BUSİNESS CONTİNUİTY MANAGEMENT İN INSURANCE SECTOR : GÜNEŞ SİGORTA","SAĞLIK KURUMLARI KRİZLERE KARŞI DİRENÇLİ Mİ?\n" +
            "ARE HEALTH INSTITUTIONS RESILIENT TO CRISIS?","",

            "AFET YÖNETİMİNDE UZAKTAN ALGILAMANIN KULLANIMI\n" +
                    "USE OF REMOTE SENSING İN DISASTER MANAGEMENT","ÇANKIRI - ELDİVAN YÖRESİ DOĞAL SÜREÇLERİ KAPSAMINDA EROZYON RİSKİ TAŞIYAN ALANLARIN BELİRLENMESİ\n" +
            "DETERMINATION OF EROSION RISK AREAS WITHIN THE SCOPE OF NATURAL PROCESSES IN ÇANKIRI - ELDİVAN REGION","GOOGLE EARTH ENGİNE İLE TAŞKIN HARİTALAMA\n" +
            "FLOOD MAPPİNG WİTH GOOGLE EARTH ENGİNE","SONLU ELEMANLAR METODU İLE YIĞMA KUBBEDE PERİYOT VE FREKANS ÜZERİNE CFRP GÜÇLENDİRME ETKİLERİNİN ARAŞTIRILMASI\n" +
            "İNVESTİGATİON OF CFRP RETROFİTTİNG EFFECT ON MASONRY DOME ON PERİOD AND FREQUENCY USİNG FİNİTE ELEMENT METHOD\n","SONLU ELEMANLAR METODU İLE YIĞMA KUBBEDE GERİLMELER ÜZERİNE CFRP GÜÇLENDİRME ETKİLERİNİN ARAŞTIRILMASI\n" +
            "İNVESTİGATİON OF CFRP RETROFİTTİNG EFFECT ON MASONRY DOME ON STRESS USİNG FİNİTE ELEMENT METHOD\n","İZMİT KENTİNDE KONUT STOKUNUN DEPREME KARŞI ‘ALGILANAN RİSK’İNİN İNCELENMESİ\n" + "EVALUATION OF OF ‘PERCEİVED RİSK’ OF HOUSİNG STOCK AGAİNST EARTHQUAKE İN IZMİT"

    };

    private String[] oturum_baskan7 = {
            "NEHİR VAROL","NEHİR VAROL","NEHİR VAROL","NEHİR VAROL","",

            "SERTAÇ TUHTA","SERTAÇ TUHTA","SERTAÇ TUHTA","SERTAÇ TUHTA","SERTAÇ TUHTA",""
    };

//for Salon 11
    private String[] txt_title8 ={
            "ESRA MUTLU, FEYZA NUR IŞIK, HAKAN ARSLAN (9514)","HAKAN ARSLAN, ALPER ÜNLÜ (9590)","TÜLAY ÇİVİCİ, YASEMİN İNCE GÜNEY(9719)","ATINÇ ÖZDEMİR BENGİ NAR (9799)","",

            "KAHRAMAN OĞUZ, MUHAMMET ALİ PEKİN (9640)","ŞÜKRÜ ERSOY, ÖZCAN ERDOĞAN, FİLİZ KATMAN (9732)","EBRU ŞAHİN, MERVE BİÇER (9824)","TARIK İLHAN (9876)",
            "SUNAY MUTLU, MUAMMER TÜN, EMRAH PEKKAN (10094)",""
     };

    private String[] txt_konu8 = {
            "AFET SONRASI KONUT ALANLARI TASARIMINDA KENTSEL BELLEĞİN SÜRDÜRÜLEBİLİRLİK YAKLAŞIMLARINA ETKİLERİNİN İNCELENMESİ\n" +
                    "THE INVESTIGATION OF URBAN MEMORY IMPACT ON POST DISASTER HOUSING AREA DESIGN THROUGH SUSTAINABILITY APPROACHES","AFET SONRASI MEKÂNSAL DEĞİŞİMİN DUYUŞSAL ETKİLERİNİN İMAJ DEĞERLENDİRME VE SEMANTİK FARKLILAŞMA YÖNTEMLERİYLE İNCELENMESİ\n" +
            "INVESTIGATION OF POST DISASTER SPATIAL CHANGE BY IMAGE EVALUATION AND SEMANTIC DIFFERENTITATION METHODS","BARINMA DİRENÇLİLİĞİ: AFET DURUMLARINDA YAPIM YÖNETİM\n" +
            "SHELTER RESILIENCE: CONSTRUCTION MANAGEMENT IN DİSASTERS","ACİL DURUM BARINAK TASARIMI ÜZERİNE STRÜKTÜREL DENEMELER\n" +
            "STRUCTURAL EXPERIMENTS ON EMERGENCY SHELTER DESIGN","",

            "23-26 NİSAN 2019 TARİHİNDE TÜRKİYE’DE GERÇEKLEŞEN TOZ TAŞINIMI OLAYININ İNCELENMESİ\n" +
                    "EVALUATION OF DUST EVENT IN TURKEY DATED ON 23-26 APRIL 2019","KIYILARIMIZIN TEHLİKELERİ: ÇEKEN AKINTILAR VE BOĞULMALAR\n" +
            "OUR COASTAL HAZARDS: RİP CURRENTS AND DROWNİNGS","DİRENÇLİ YERLEŞKELER VE BÜTÜNLEŞİK DOĞAL HASSASİYETLERİNİN DEĞERLENDİRİLMESİ\n" +
            "EVALUATİON OF RESİSTANT SETTLEMENTS AND INTEGRATED NATURAL SENSİTİVİTY","19. YÜZYILDA İZMİR'DEKİ ÖNEMLİ DOĞAL AFETLER IMPORTANT NATURAL DISASTERS IN IZMIR IN THE 19th CENTURY",
            "Deprem ve Sismik Ağ İzleme Earthquake and Seismic Network Monitoring",""

    };

    private String[] oturum_baskan8 = {
            "HAKAN ARSLAN","HAKAN ARSLAN","HAKAN ARSLAN","HAKAN ARSLAN","",

            "NEHİR VAROL","NEHİR VAROL","NEHİR VAROL","NEHİR VAROL","NEHİR VAROL","NEHİR VAROL"
    };

//for Salon 12
    private String[] txt_title9 ={
            "AYŞE KARAHAN, FİGEN DİLEK İLKE (9079)","SİBEL SARIÇAM (9832)","ESMA AKSOY KHURAMİ, SILA CEREN VARIŞ (9840)","MELDA AÇMAZ ÖZDEN (9887)","SEVDE SOĞANCI, NUR SİNEM PARTİGÖÇ (9885)",

            "ESMA AKSOY KHURAMİ (9490)","PERVİN ŞENOL (9936)","MEDİHA BURCU SILAYDIN AYDIN, NUR SİNEM PARTİGÖÇ, HAYAT ZENGİN ÇELİK, HİLMİ EVREN ERDİN (9864)","ESRA SALT, EMİNE YILMAZ (9896)",
            "BALCA AĞAÇSAPAN, EMRAH PEKKAN, ALPER ÇABUK (10070)",""
    };

    private String[] txt_konu9 = {
            "DİRENÇLİ KENTLER BAĞLAMINDA KARAMAN KENTİNİN DEĞERLENDİRİLMESİ\n" +
                    "EVALUATION OF KARAMAN BY MEANS OF RESILIENT CITIES","DİRENÇLİ KENTLER OLUŞTURMADA PEYZAJ MİMARLARININ SORUMLULUKLARI\n" +
            "RESPONSİBİLİTİES OF LANDSCAPE ARCHİTECTS İN FORMİNG RESİLİENCE CİTİES","BÖLGESEL KALKINMA PLANLARI SORUNSALI: KIRILAN BÖLGESEL DİRENÇLİLİK\n" +
            "THE PROBLEMATIC OF REGIONAL DEVELOPMENT PLANS: BROKEN REGIONAL RESILIENCE","DİRENÇLİ VE YAŞANABİLİR FİZİKSEL ÇEVRENİN ÜRETİMİNDE BİYOFİLİK TASARIM YAKLAŞIMI BİR ÇÖZÜM OLABİLİR Mİ?\n" +
            "COULD THE BİOPHİLİC DESİGN AOPPROACH BE A SOLUTİON İN PRODUCTİON OF RESİLİENT AND LİVEABLE PHYSİCAL ENVİRONMENT?","KÜRESEL İKLİM DEĞİŞİKLİĞİ SÜRECİNDE AFET YÖNETİMİ UYGULAMALARI: TARIM SEKTÖRÜ AÇISINDAN BİR DEĞERLENDİRME\n" +
            "DİSASTER MANAGEMENT PRACTİCES İN THE PROCESS OF GLOBAL CLİMATE CHANGE: A REVİEW REGARDİNG THE AGRİCULTURAL SECTOR",

            "DAHA FAZLA İNŞAAT?\n" +
                    "ANYMORE CONSTRUCTION?","İKLİM DEĞİŞİKLİĞİ SÜRECİNDE RİSKLER VE KENTSEL DİRENÇLİLİĞE YÖNELİK MEKANSAL STRATEJİLER\n" +
            "RİSKS İN THE CLİMATE CHANGE PROCESS AND SPATİAL STRATEGİES FOR URBAN RESİLİENCE","POTANSİYEL TOPLANMA ALANLARININ İMAR PLANLARINDAKİ DURUMU: İZMİR ÖRNEĞİ\n" +
            "ASSESSMENT OF POTENTIAL GATHERING AREAS’ STATUS IN DEVELOPMENT PLANS: THE CASE OF IZMIR CITY","REZERV YAPI ALANLARINDA AFET YÖNETİM PLANI: İSTANBUL İÇİN BİR MODEL ÖNERİSİ\n" +
            "DISASTER MANAGEMENT PLAN IN RESERVE BUILDING AREAS: A MODEL PROPOSAL FOR ISTANBUL","DİRENÇLİLİK VE EKOSİSTEM SERVİSLERİ BAĞLAMINDA EKOSİSTEM SERVİSLERİNİN SOİL AND WATER ASSESSMENT TOOL(SWAT) İLE MODELLENMESİ; SİSTEMATİK İNCELEME\n" +
            "MODELİNG OF ECOSYSTEM SERVİCES İN THE CONTEXT OF RESİLİENCE AND ECOSYSTEM SERVİCES WİTH SOİL AND WATER ASSESSMENT TOOL (SWAT); SYSTEMATİC REVİEW",""
    };

    private String[] oturum_baskan9 = {
            "SİBEL SARIÇAM","SİBEL SARIÇAM","SİBEL SARIÇAM","SİBEL SARIÇAM","SİBEL SARIÇAM",

            "EMRAH PEKKAN","EMRAH PEKKAN","EMRAH PEKKAN","EMRAH PEKKAN","EMRAH PEKKAN",""
    };

    //for Salon 13
    private String[] txt_title10 ={
            "MUSTAFA EMRE DÖŞ, MURAT UYSAL (10083)","MURAT UYSAL, Mustafa YILMAZ, İBRAHİM TİRYAKİOĞLU (10098)","ÖZCAN ERDOĞAN, HÜLYA ARABACI (10071)","SEZGÜL ŞAHİN (9856)","HÜSEYİN BAYRAKTAR, ELİF SAHTİYANCI, ALİ KURU, BURCU YILMAZ BAYRAKTAR (9480)",

            "SİBEL ÇELİKEL YİĞİTER (9857)","KURTULUŞ KARAKUŞ, İMRAN ASLAN (9406)","İMRAN ASLAN, YASİN ÇELİK (9491)","",
            "",""
    };

    private String[] txt_konu10 = {
            "Afet Yönetiminde Derin Öğrenme ile Uzaktan Algılama Verilerini Kullanma Using Remote Sensing Data with Deep Learning in Disaster Management",
            "İnsansız hava araçları ile afet öncesi 3B şehir haritalama Pre-disaster 3D city mapping with unmanned aerial vehicles",
            "Kitlesel Olaylarda Lojistik Hazırlık ve Sağlık Tedbiri Planlamaları Logistic Preparation and Health Measure Planning in Mass Events",
            "Kalori Kısıtlamanın Sağlıklı Yaşlanma Üzerine Etkileri The Effects of Calorie Restriction on Healthy Aging",
            "OKULLARDA YAPISAL OLMAYAN ELEMANLARIN AFET KAYNAKLI OLASI RİSKLERİNİN L TİPİ MATRİS YÖNTEMİYLE BELİRLENMESİ DETERMINATION OF THE POSSIBLE RISKS OF DISASTER RESOURCES OF NON-STRUCTURAL ELEMENTS IN SCHOOLS BY L-TYPE MATRIX METHOD",

            "Teknolojik Afetlerin Önlenmesinde İş Sağlığı ve Güvenliğinin Rolü The Role of Occupational Health and Safety in the Prevention of Technological Disasters",
            "ARICILIK İŞLETMELERİNDE İŞ SAĞLIĞI VE GÜVENLİĞİ: BİNGÖL ÖRNEĞİ OCCUPATIONAL HEALTH AND SAFETY IN BEEKEEPING ENTERPRICES: BİNGÖL EXAMPLE",
            "ELEKTRİK KAZALARIN İŞ SAĞLIĞI VE GÜVENLİĞİNİ YÖNÜNDEN İNCELENMESİ INVESTIGATION OF ELECTRIC ACCIDENTS IN OCCUPATIONAL HEALTH AND SAFETY",
            "","",""
    };

    private String[] oturum_baskan10 = {
            "SİBEL SARIÇAM","SİBEL SARIÇAM","SİBEL SARIÇAM","SİBEL SARIÇAM","SİBEL SARIÇAM",

            "","","","","",""
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_tab2, container, false);

        btn3 = inflate.findViewById(R.id.btn2_1); //Salon3
        btn4 = inflate.findViewById(R.id.btn2_14); //Salon4
        btn5 = inflate.findViewById(R.id.btn2_2);  //Salon5
        btn6 = inflate.findViewById(R.id.btn2_3);  //Salon6
        btn7 = inflate.findViewById(R.id.btn2_4);  //Salon7
        btn8 = inflate.findViewById(R.id.btn2_5);  //Salon8
        btn9 = inflate.findViewById(R.id.btn2_6);  //Salon9
        btn10 = inflate.findViewById(R.id.btn2_7);  //Salon10
        btn11 = inflate.findViewById(R.id.btn2_8);  //Salon11
        btn12 = inflate.findViewById(R.id.btn2_9);  //Salon12
        btn13 = inflate.findViewById(R.id.btn2_10); //Salon13
        title = inflate.findViewById(R.id.title2_salon);

        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);

        Tab1Adapter tab1Adapter = new Tab1Adapter(getActivity(),txt_clock,txt_title);
        listView = inflate.findViewById(R.id.list_tab2);
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
                        //go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        //go_details.putExtra("baskan",oturum_baskan14[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        //go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        //go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        //go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        //go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        //go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        //go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        //go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        //go_details.putExtra("baskan",oturum_baskan9[position]);
                    }else if(clilcked_btn.equals("Salon 13")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title10[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu10[position]);
                        //go_details.putExtra("baskan",oturum_baskan10[position]);
                    }

                    startActivity(go_details);
                }else if(position == 1){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        //go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        //go_details.putExtra("baskan",oturum_baskan14[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        //go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        //go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        //go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        //go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        //go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        //go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        //go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        //go_details.putExtra("baskan",oturum_baskan9[position]);
                    }else if(clilcked_btn.equals("Salon 13")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title10[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu10[position]);
                        //go_details.putExtra("baskan",oturum_baskan10[position]);
                    }

                    startActivity(go_details);

                }else if(position == 2){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        //go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        //go_details.putExtra("baskan",oturum_baskan14[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        //go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        //go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        //go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        //go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        //go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        //go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        //go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        //go_details.putExtra("baskan",oturum_baskan9[position]);
                    }else if(clilcked_btn.equals("Salon 13")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title10[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu10[position]);
                        //go_details.putExtra("baskan",oturum_baskan10[position]);
                    }

                    startActivity(go_details);

                }else if(position == 3){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        //go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        //go_details.putExtra("baskan",oturum_baskan14[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        //go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        //go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        //go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        //go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        //go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        //go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        //go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        //go_details.putExtra("baskan",oturum_baskan9[position]);
                    }else if(clilcked_btn.equals("Salon 13")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title10[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu10[position]);
                        //go_details.putExtra("baskan",oturum_baskan10[position]);
                    }

                    startActivity(go_details);

                }else if(position == 4){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        //go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        //go_details.putExtra("baskan",oturum_baskan14[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        //go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        //go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        //go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        //go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        //go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        //go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        //go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        //go_details.putExtra("baskan",oturum_baskan9[position]);
                    }else if(clilcked_btn.equals("Salon 13")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title10[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu10[position]);
                        //go_details.putExtra("baskan",oturum_baskan10[position]);
                    }

                    startActivity(go_details);

                }else if(position == 5){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        //go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        //go_details.putExtra("baskan",oturum_baskan14[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        //go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        //go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        //go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        //go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        //go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        //go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        //go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        //go_details.putExtra("baskan",oturum_baskan9[position]);
                    }else if(clilcked_btn.equals("Salon 13")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title10[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu10[position]);
                        //go_details.putExtra("baskan",oturum_baskan10[position]);
                    }

                    startActivity(go_details);

                }else if(position == 6){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        //go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        //go_details.putExtra("baskan",oturum_baskan14[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        //go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        //go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        //go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        //go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        //go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        //go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        //go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        //go_details.putExtra("baskan",oturum_baskan9[position]);
                    }else if(clilcked_btn.equals("Salon 13")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title10[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu10[position]);
                        //go_details.putExtra("baskan",oturum_baskan10[position]);
                    }

                    startActivity(go_details);

                }else if(position == 7){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        //go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        //go_details.putExtra("baskan",oturum_baskan14[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        //go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        //go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        //go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        //go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        //go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        //go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        //go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        //go_details.putExtra("baskan",oturum_baskan9[position]);
                    }else if(clilcked_btn.equals("Salon 13")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title10[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu10[position]);
                        //go_details.putExtra("baskan",oturum_baskan10[position]);
                    }

                    startActivity(go_details);

                }else if(position == 8){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        //go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        //go_details.putExtra("baskan",oturum_baskan14[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        //go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        //go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        //go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        //go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        //go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        //go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        //go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        //go_details.putExtra("baskan",oturum_baskan9[position]);
                    }else if(clilcked_btn.equals("Salon 13")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title10[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu10[position]);
                        //go_details.putExtra("baskan",oturum_baskan10[position]);
                    }

                    startActivity(go_details);

                }else if(position == 9){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        //go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        //go_details.putExtra("baskan",oturum_baskan14[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        //go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        //go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        //go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        //go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        //go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        //go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        //go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        //go_details.putExtra("baskan",oturum_baskan9[position]);
                    }else if(clilcked_btn.equals("Salon 13")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title10[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu10[position]);
                        //go_details.putExtra("baskan",oturum_baskan10[position]);
                    }

                    startActivity(go_details);

                }else if(position == 10){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        //go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        //go_details.putExtra("baskan",oturum_baskan14[position]);
                    }else if(clilcked_btn.equals("Salon 5")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title2[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu2[position]);
                        //go_details.putExtra("baskan",oturum_baskan2[position]);
                    }else if(clilcked_btn.equals("Salon 6")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title3[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu3[position]);
                        //go_details.putExtra("baskan",oturum_baskan3[position]);
                    }else if(clilcked_btn.equals("Salon 7")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title4[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu4[position]);
                        //go_details.putExtra("baskan",oturum_baskan4[position]);
                    }else if(clilcked_btn.equals("Salon 8")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title5[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu5[position]);
                        //go_details.putExtra("baskan",oturum_baskan5[position]);
                    }else if(clilcked_btn.equals("Salon 9")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title6[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu6[position]);
                        //go_details.putExtra("baskan",oturum_baskan6[position]);
                    }else if(clilcked_btn.equals("Salon 10")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title7[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu7[position]);
                        //go_details.putExtra("baskan",oturum_baskan7[position]);
                    }else if(clilcked_btn.equals("Salon 11")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title8[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu8[position]);
                        //go_details.putExtra("baskan",oturum_baskan8[position]);
                    }else if(clilcked_btn.equals("Salon 12")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title9[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu9[position]);
                        //go_details.putExtra("baskan",oturum_baskan9[position]);
                    }else if(clilcked_btn.equals("Salon 13")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title10[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu10[position]);
                        //go_details.putExtra("baskan",oturum_baskan10[position]);
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


            case R.id.btn2_1:
                //Salon 3
                title.setText(getString(R.string.salon3));
                clilcked_btn = getString(R.string.salon3);

                Tab1Adapter tab1Adapter = new Tab1Adapter(getActivity(),txt_clock,txt_title);
                listView = inflate.findViewById(R.id.list_tab2);
                listView.setAdapter(tab1Adapter);

                break;

            case R.id.btn2_2:
                //Salon 5
                title.setText(R.string.salon5);
                clilcked_btn = getString(R.string.salon5);

                Tab1Adapter tab1Adapter2 = new Tab1Adapter(getActivity(),txt_clock,txt_title2);
                listView = inflate.findViewById(R.id.list_tab2);
                listView.setAdapter(tab1Adapter2);

                break;

            case R.id.btn2_3:
                //Salon 6
                title.setText(R.string.salon6);
                clilcked_btn = getString(R.string.salon6);

                Tab1Adapter tab1Adapter3 = new Tab1Adapter(getActivity(),txt_clock,txt_title3);
                listView = inflate.findViewById(R.id.list_tab2);
                listView.setAdapter(tab1Adapter3);

                break;

            case R.id.btn2_4:
                //Salon 7
                title.setText(R.string.salon7);
                clilcked_btn = getString(R.string.salon7);

                Tab1Adapter tab1Adapter7 = new Tab1Adapter(getActivity(),txt_clock,txt_title4);
                listView = inflate.findViewById(R.id.list_tab2);
                listView.setAdapter(tab1Adapter7);

                break;

            case R.id.btn2_5:
                //Salon 8
                title.setText(R.string.salon8);
                clilcked_btn = getString(R.string.salon8);

                Tab1Adapter tab1Adapter8 = new Tab1Adapter(getActivity(),txt_clock,txt_title5);
                listView = inflate.findViewById(R.id.list_tab2);
                listView.setAdapter(tab1Adapter8);

                break;

            case R.id.btn2_6:
                //Salon 9
                title.setText(R.string.salon9);
                clilcked_btn = getString(R.string.salon9);

                Tab1Adapter tab1Adapter9 = new Tab1Adapter(getActivity(),txt_clock,txt_title6);
                listView = inflate.findViewById(R.id.list_tab2);
                listView.setAdapter(tab1Adapter9);

                break;

            case R.id.btn2_7:
                //Salon 10
                title.setText(R.string.salon10);
                clilcked_btn = getString(R.string.salon10);

                Tab1Adapter tab1Adapter10 = new Tab1Adapter(getActivity(),txt_clock,txt_title7);
                listView = inflate.findViewById(R.id.list_tab2);
                listView.setAdapter(tab1Adapter10);

                break;

            case R.id.btn2_8:
                //Salon 11
                title.setText(R.string.salon11);
                clilcked_btn = getString(R.string.salon11);

                Tab1Adapter tab1Adapter11 = new Tab1Adapter(getActivity(),txt_clock,txt_title8);
                listView = inflate.findViewById(R.id.list_tab2);
                listView.setAdapter(tab1Adapter11);

                break;

            case R.id.btn2_9:
                //Salon 12
                title.setText(R.string.salon12);
                clilcked_btn = getString(R.string.salon12);

                Tab1Adapter tab1Adapter12 = new Tab1Adapter(getActivity(),txt_clock,txt_title9);
                listView = inflate.findViewById(R.id.list_tab2);
                listView.setAdapter(tab1Adapter12);

                break;

            case R.id.btn2_14:
                //Salon 4
                title.setText(R.string.salon4);
                clilcked_btn = getString(R.string.salon4);

                Tab1Adapter tab1Adapter14 = new Tab1Adapter(getActivity(),txt_clock,txt_title14);
                listView = inflate.findViewById(R.id.list_tab2);
                listView.setAdapter(tab1Adapter14);

                break;

            case R.id.btn2_10:
                //Salon 13
                title.setText(R.string.salon13);
                clilcked_btn = getString(R.string.salon13);

                Tab1Adapter tab1Adapter13 = new Tab1Adapter(getActivity(),txt_clock,txt_title10);
                listView = inflate.findViewById(R.id.list_tab2);
                listView.setAdapter(tab1Adapter13);

                break;
        }
    }
}

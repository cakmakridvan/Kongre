package com.rota.kongresistem.fragment;

import android.content.Context;
import android.content.Intent;
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

import com.rota.kongresistem.R;
import com.rota.kongresistem.activity.Details;
import com.rota.kongresistem.adapter.Tab1Adapter;

public class Tab3 extends Fragment implements View.OnClickListener {

    private View inflate;
    private ListView listView;
    private TextView title;
    private String clilcked_btn = "";
    private Button btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;

//for Salon 3
    private String[] txt_clock ={
            "10:00 - 10:20","10:20 - 10:40","10:40 - 11:00","11:00 - 11:20","11:20 - 11:40","11:40 - 12:00",

            "14:00 - 14:20","14:20 - 14:40","14:40 - 15:00","15:00 - 15:20","15:20 - 15:40",

            "16:20 - 16:40","16:40 - 17:00","17:00 - 17:20","17:20 - 17:40","17:40 - 18:00","18:00 - 18:20"
    };

    private String[] txt_title  ={
            "HÜSEYİN BAYRAKTAR, DURSUN YILDIRIM BAYAR, HAKAN GÜVEN, HARUN BADEM, EDA SOYLU SENGÖR, BESTAMİ KARA , BUKET GÜLŞEN, GÜLENAY ŞAHİN (9957)","AYNUR ULUÇ, DİDİER BOUAKAZE-KHAN MELTEM ŞENOL-BALABAN (9881)",
            "GÜLSEREN BAYSAL, YILDIRIM BAYAR, HÜSEYİN BAYRAKTAR (9736)","ERKAN POLAT, SÜMEYYE KAHRAMAN (9938)","ESMA KARAKOYUN, SÜLEYMAN TOY (9652)","MAHMUT YILDIRIM, RESUL AYYILDIZ, SÜLEYMAN TOY (9605)",

            "MERT HACIEMİROĞLU, BANU AYDIN, CAN ÖZGELDİ (9485)","AHMAD ASWAD, SALAH HAJ ISMAİL, ABDULLAH DİLSİZ (9814)","GÜLÇİN SAĞIR (9452)","BURAK BÜYÜKCİVELEK , SILA CEREN VARIŞ (9828)","",

            "EFNAN ŞORA GÜNAL, UĞUR GÜREL, SERKAN GÜNAL (9729)","LEYLA DERİN, MURAT ERCANOĞLU, NEHİR VAROL (9915)","ALİ EKŞİ (9464)","SELMA KOÇ AKGÜL, OĞUZ GÜNDOĞDU, OZDEN IŞIK (9835)","",""

    };

    private String[] txt_konu = {
            "2019-2022 ULUSAL AKILLI ŞEHİR STRATEJİSİ VE EYLEM PLANI\n" +
                    "2019-2022 NATİONAL SMART CİTİES STRATEGY AND ACTİON PLAN\n","FARKLI KURUMSAL ÇERÇEVELERİN KÜLTÜREL MİRAS ALANLARIN KORUNMASINDA RİSK YÖNETİMİ AÇISINDAN KARŞILAŞTIRMASI:\n" +
            "İNGİLTERE, JAPONYA VE TÜRKİYE UNESCO DÜNYA MİRAS ALANI ÖRNEKLERİ\n" +
            "THE COMPARISON OF DIFFERENT INSTITUTIONAL FRAMEWORKS REGARDING RISK MANAGEMENT FOR CONSERVATION OF CULTURAL HERITAGE:\n" +
            "THE CASE OF BRITAIN, JAPAN AND TURKEY UNESCO WORLD HERITAGE SITES","KENTSEL DİRENÇLİLİĞİN GELİŞTİRİLMESİNDE AÇIK VERİ KULLANIMI\n" +
            "OPEN DATA USAGE IN DEVELOPING URBAN RESISTIVITY","ANTROPOSEN ÇAĞI’NDA KENTSELLİK, SÜRDÜRÜLEBİLİRLİK VE DİRENÇLİLİK\n" +
            "URBANİSM, SUSTAİNABİLİTY AND RESİLİENCE İN THE ANTHROPOCENE ERA","KIŞ KENTLERİNDE BİYOKLİMATİK KONFOR ŞARTLARININ MAHALLE KÜLTÜRÜNE ETKİSİ; ERZURUM ÖRNEĞİ\n" +
            "EFFECT OF BİOCLİMATİC COMFORT CONDİTİONS ON NEİGHBORHOOD CULTURE İN WİNTER CİTİES; ERZURUM SAMPLE","ERZURUM GELENEKSEL MİMARİSİNDE BİYOKLİMATİK KONFOR DUYARLI UYGULAMA ÖRNEKLERİ\n" +
            "BİOCLİMATİC COMFORT SENSİTİVE APPLİCATİON EXAMPLES İN ERZURUM TRADİTİONAL ARCHİTECTURE",

            "DEPREM İKİNCİL AFETLERİNİN ÖNLENMESİNDE JAPONYA’DA KULLANILAN GERÇEK ZAMANLI MÜDAHALE SİSTEMLERİ\n" +
                    "REAL-TIME INTERVENTION SYSTEMS USED IN JAPAN FOR PREVENTING EARTHQUAKE SECONDARY DISASTERS","AFETSELLİĞİ YÜKSEK İKİ ÜLKEDE ULUSAL VE YEREL DÜZEYLERDE AFET RİSKİ YÖNETİŞİMİNİN ROLÜ\n" +
            "THE ROLE OF DİSASTER RİSK GOVERNANCE ON NATİONAL AND LOCAL LEVELS IN TWO DİSASTER-PRONE COUNTRİES\n","KENT GÜVENLİĞİ: DİRENÇLİ KENTLER VE GÖÇLER\n" +
            "URBAN SAFETY: RESISTANT CITIES AND MIGRATIONS","YARATICI SINIF SAVI VE KENTSEL DİRENÇLİLİK: ANKARA TEKNOKENT ÇALIŞANLARI ÖRNEĞİ\n" +
            "CREATİVE CLASS THESİS AND URBAN RESİLİENCE: THE CASE OF TECHNOPOLİS WORKERS İN ANKARA","",

            "DEPREM KONUMUNUN TAHMİNİ: TÜRKİYE İÇİN BİR VAKA ÇALIŞMASI\n" +
                    "PREDİCTİON OF EARTHQUAKE LOCATİON: A CASE STUDY FOR TURKİYE\n","HEYELAN DUYARLILIK HARİTALARININ OLUŞTURULMASINDA KULLANILAN FARKLI ANALİTİK HİYERARŞİ SÜRECİ (AHP) YÖNTEMLERİ: GENEL BİR DEĞERLENDİRME\n" +
            "DİFFERENT ANALYTİCAL HİERARCHY PROCESS METHODS (AHP) USED İN LANDSLİDE SUSCEPTİBİLİTY MAP PRODUCTİON: A GENERAL REVİEW","Yıkıcılık ve Olasılığı Artan Afet Risklerinin Toplumsal Yapı Üzerine Etkileri Effects of More Destructive and Probable Disaster Risks on Social Structure","AFET/ RİSK FARKINDALIĞI, YEREL BASIN VE KAMUOYU ESKİŞEHİR, GAZİANTEP VE KOCAELİ ÖRNEĞİ\n" +
            "DİSASTER/RİSK AWARENESS, LOCAL PRESS AND PUBLİC OPİNİON SAMPLE OF ESKİŞEHİR, GAZİANTEP, KOCAELİ\n","",""

    };

    private String[] oturum_baskan = {
            "HÜSEYİN BAYRAKTAR","HÜSEYİN BAYRAKTAR","HÜSEYİN BAYRAKTAR","HÜSEYİN BAYRAKTAR","HÜSEYİN BAYRAKTAR","HÜSEYİN BAYRAKTAR",

            "ABDULLAH DİLSİZ","ABDULLAH DİLSİZ","ABDULLAH DİLSİZ","ABDULLAH DİLSİZ","",

            "BÜLENT ÖZMEN","BÜLENT ÖZMEN","BÜLENT ÖZMEN","BÜLENT ÖZMEN","",""

    };
//for Salon 4
    private String[] txt_title14  ={
            "DENİZ ÇAĞLAYAN GÜMÜŞ","ALİ TELLİ, AHMET ALİ ARTUN, NİHAN SEZGİN DOĞRUL, UĞUR TUNCA, ERCÜMENT KÖK (9444)","GÜLHAN ŞEN, AYŞE KARABULUT, TUTKU PEKDAŞ, EBRU KELEŞ (9688)",
            "ONUR KURT, MUAMMER TÜN, ERKAN KURNAZ, TEZCAN ÇAVUŞOĞLU (9827)","ERKAN KURNAZ, ONUR KURT (9829)","ALİ TELLİ (9525)",

            "AYLİN ÇELİK, MELTEM SENOL BALABAN, SHAGHAYEGH KARİMZADEH, AYSEGUL ASKAN (9898)","HİLMİ EVREN ERDİN, FARANAK KHANMOHAMMADİKOL (9914)","HALE MAMUNLU KOCABAŞ (9917)","ZEYNEP DENİZ YAMAN GALANTİNİ (9632)","",

            "SÜLEYMAN TOY, CANSU GÜLLER (9600)","SÜLEYMAN TOY, MURAT TÜRKEŞ (9642)","ZELİHA ÖZEL, ÖZGE YALÇINER ERCOŞKUN (9648)","UGUR BOZKURT, KORAY VELİBEYOĞLU (9693)","",""
    };

    private String[] txt_konu14 = {
            "Engellilere Yönelik Afet Yönetiminde Erişilebilirligin Önemi The Importance of Accessibility in Disaster Management for People with Disability","\"Z-EVET\" ENGELLİ VERİTABANININ ve ENGELLİ AFET EĞİTİM MODELİ\n" +
            "\"Z-YES\" AF DISABLED DATABASE AND DISABLED DISASTER TRAINING MODEL","EĞİTMENLERİN AFETLERDE ENGELLİ BİREYLERE NASIL DAVRANACAĞI KONUSUNDA Kİ FARKINDALIK DÜZEYLERİNİN BELİRLENMESİ\n" +
            "DETERMİNİNG THE LEVEL OF AWARENESS OF TRAİNERS ABOUT HOW BEHAVE TO PEOPLE WİTH DİSABİLİTİES İN DİSASTERS\n","ÖZEL GEREKSİNİMLİ BİREYLER DEPREME HAZIR MI? TÜRKİYE İÇİN BİR DURUM VE GEREKSİNİM TESPİT ÇALIŞMASI\n" +
            "ARE THE INDIVIDUALS WITH SPECIAL NEEDS READY FOR EARTHQUAKES? A SİTUATİON AND NEEDS ASSESSMENT STUDY FOR TURKEY","AFETLERDE ÖZEL GEREKSİNİMLİ BİREYLERE İLİŞKİN ULUSLARARASI DENEYİMLER\n" +
            "CRISIS MANAGEMENT FOR INDIVIDUALS WITH SPECIAL NEEDS IN DISASTERS AND EMERGENCIES: INTERNATIONAL EXPERIENCES","AFETLERE HAZIRLIKTA “GÖNÜLLÜ İNSAN KAYNAKLARI ORGANİZASYONU”, MARŞ MİRA(BARIŞ YOLU) UYGULAMA ÖRNEĞİ ORGANIZATION OF VOLUNTEER HUMAN RESOURCES IN PREPARATION FOR DISASTERS, MARŞ MİRA (PEACE ROAD) APPLICATION EXAMPLE",

            "ZEMİN HAREKETİ SİMÜLASYONLARI KULLANIMIYLA ERZİNCAN ŞEHRİNİN GEÇMİŞ VE GELECEK KENTSEL RİSKLERİN DEĞERLENDİRMESİ\n" +
                    "EVALUATION OF HISTORICAL AND FUTURE URBAN RISKS OF ERZİNCAN CITY BY USING GROUND MOTION SIMULATION\n","TARİHİ KENT MERKEZLERİNİN AFET VE ACİL DURUMLARDAKİ RİSKLERİNİN ERİŞİLEBİLİRLİK VE GÜVENLİK KRİTERLERİ AÇISINDAN İRDELENMESİ\n" +
            "INVESTIGATION OF THE RISKS OF HISTORICAL CITY CENTERS IN DISASTER AND EMERGENCY IN TERMS OF THE ACCESSIBILITY AND SAFETY CRITERIA","İSTANBUL’DA SEL VE TAŞKIN RİSKİNİN MEKANSAL PLANLAMA VE YÖNETİM YAKLAŞIMLARI BAĞLAMINDA DEĞERLENDİRİLMESİ\n" +
            "EVALUATION OF FLOOD RISK IN CONTEXT OF SPATIAL PLANNING AND MANAGEMENT APPROACHES IN ISTANBUL","DAYANIKLILIĞIN (DİRENÇLİLİĞİN) KÖKENİ, PERKSPEKTİFLERİ VE NİTELİKLERİ ÜZERİNDEN KAVRAMSAL DEĞERLENDİRMESİ: “RESILEMENT”’DAN KENTSEL DAYANIKLILIĞA\n" +
            "CONCEPTUAL ASSESSMENT OF RESILIENCE THROUGH ITS ORIGINS, PERSPECTIVES AND ATTRIBUTES: FROM “RESILEMENT” TO URBAN RESILIENCE\n","",

            "Kentsel Isı Adası Oluşumuna Yatkınlık Kriterlerinin Belirlenmesi: Erzurum ve Erzincan Örneği Determination of vulnerability criteria for UHI formation: The Case of Erzurum and Erzincan",
            "Biyoklimatik bilginin mekansal planlama ve kentsel tasarım uygulamalarında kullanımı: Türkiye için iklim değişikliğini dikkate alan öneriler Use of bioclimatological knowledge in spatial planning and urban design practices: suggestions for Turkey considering climate change",
            "Kentsel Dönüşüm Strateji Belgelerinde Sürdürülebilirlik Değerlendirmesi: Kilis Örneği Sustainability Assessment in Urban Transformation Strategy Paper: Kilis Case",
            "Deprem Riski Olan Alanlarda Farklı Kentsel Dönüşüm Stratejilerinin Etkinlik Göstergeleri The Effectiveness Indicators of Different Urban Transformation Strategies in Earthquake-Prone Areas",
            "",""

    };

    private String[] oturum_baskan14 = {
            "DENİZ ÇAĞLAYAN GÜMÜŞ","DENİZ ÇAĞLAYAN GÜMÜŞ","DENİZ ÇAĞLAYAN GÜMÜŞ","DENİZ ÇAĞLAYAN GÜMÜŞ","DENİZ ÇAĞLAYAN GÜMÜŞ","",

            "MELTEM ŞENOL BALABAN","MELTEM ŞENOL BALABAN","MELTEM ŞENOL BALABAN","MELTEM ŞENOL BALABAN","","",

            "AHMET TÜRK","AHMET TÜRK","AHMET TÜRK","AHMET TÜRK","",""

    };
//for Salon 5
    private String[] txt_title2  ={
            "FATMA SÜLÜN, DİLEK ÖZTAŞ, AYTUNÇ ATEŞ (9752)\n","SERMET SEZİGEN (9803)\n","SERMET SEZİGEN, RUŞEN KORAY EYİSON, LEVENT KENAR (9804)",
            "İLHAN ÖZTÜRK, ETHEM GÜNEREN, ÖZCAN ERDOĞAN, ALPASLAN MAYADAĞLI (9939)\n","YELİZ ÇATAK, ŞULE ÖZEL, YAPRAK ENGİN ÜSTÜN (10100)","",

            "AYŞE ÖZYETGİN ALTUN (9754)","AHMET USLU, HASAN BURAK ÖZMEN, ENGİN KORKMAZ, BARIŞ ECER, MÜBERRA KÖK, EMİN ŞAHBAZLI, EMRAH PEKKAN, MUAMMER TÜN (9851)","ALİYE CEREN ONUR (9855)","ADEM DEMİR (10063)","",

            "DİDEM GÜNEŞ YILMAZ (9705)","FATİH YAMAN, EVREN AYRANCI, İSMAİL HAKKI HELVACIOĞLU (9820)","CIGDEM COSKUN HEPCAN, SERİF HEPCAN (9653)","AHMET TÜRK (9796)","",""
    };

    private String[] txt_konu2 = {
            "KBRN OLAYLARINDA BİYOLOJİK TEHDİTLERİN ACİL DURUM YÖNETİMİ\n" +
                    "EMERGENCY MANAGEMENT OF BIOLOGICAL THREATS IN CBRN EVENTS","YATAKLI TEDAVİ TESİSLERİNDE TIBBİ KBRN SAVUNMASININ HAZIRLANMASI\n" +
            "PREPARİNG MEDİCAL CBRN RESPONSE PLAN FOR HEALTH FACİLİTİES","KİMYASAL TERÖRİST SALDIRILARIN SONRASINDA DEKONTAMİNASYON YAKLAŞIMLARI\n" +
            "DECONTAMİNATİON APPROACHES FOLLOWİNG CHEMİCAL TERRORİST ATTACKS\n","AFET TIBBI AÇISINDAN KİMYASAL SİLAH YARALILARININ YÖNETİMİ\n" +
            "MANAGEMENT OF CHEMİCAL WEAPONS VİCTİMS İN TERMS OF DİSASTER MEDİCİNE","TEHLİKELİ MADDE GÜVENLİĞİNİN KBRN AÇISINDAN ÖNEMİ\n" +
            "IMPORTANCE OF DANGEROUS GOODS SAFETY IN TERMS OF CBRN","",

            "AFET RİSK YÖNETİMİ KAPSAMINDA KENT PLANLAMANIN ROLÜ VE İÇERİĞİ THE ROLE AND SCOPE OF URBAN PLANNING FOR DISASTER RISK MANAGEMENT",
            "YERLEŞİM YERLERİ İÇİN MEVCUT ACİL TOPLANMA ALANLARININ UYGUNLUĞUNUN COĞRAFİ BİLGİ SİSTEMLERİ (CBS) İLE DEĞERLENDİRİLMESİ: ESKİŞEHİR ÖRNEĞİ EVALUATION OF THE SUITABILITY OF THE EMERGENCY ASSEMBLY AREAS FOR THE SETTLEMENTS WITH GEOGRAPHİCAL INFORMATION SYSTEMS (GIS): THE CASE OF ESKİŞEHİR",
            "Kentsel Alanlardaki Taşkınların Yeşil Koridor ve Dirençlilik Çerçevesinde İrdelenmesi- İstanbul Evaluation of Floods in Urban Areas Under Green Corridor and Resilience Perspective- Istanbul",
            "TOPLUMSAL DİRENÇ OLUŞTURMADA TOPLUM MERKEZLERİNİN ROLÜ THE ROLE OF COMMUNITY CENTERS IN SOCIAL RESISTANCE",
            "",

            "Planlama bakışından Bursa ili afet riski değerlendirmesi An evaluation of disaster risk of Bursa from the planning perspective",
            "Türkiye Afet ve Acil Durum Yönetimi Sistemi için Bir Değerlendirme Evaluation of Turkish Disaster and Emergency Management System",
            "Dayanikli Kentler Olusturmada Sunger Kent Uygulamalari Sponge City Practices for Resilient Cities",
            "DÜNYA’DA UYGULANAN AFET ZARARLARINI AZALTMA YÖNTEMLERİNİN TÜRKİYE’DE UYGULANABİLİRLİĞİ; ISPARTA ÖRNEĞİ APPLICABILITY IN TURKEY OF DISASTER METHODS TO REDUCE THE WORLD; ISPARTA EXAMPLE",
            "",""

    };

    private String[] oturum_baskan2 = {
            "SERMET SEZİGEN","SERMET SEZİGEN","SERMET SEZİGEN","SERMET SEZİGEN","SERMET SEZİGEN","",

            "DENİZ GERÇEK KURT","DENİZ GERÇEK KURT","DENİZ GERÇEK KURT","DENİZ GERÇEK KURT","",

            "DERYA DEMİRDİZEN ÇEVİK","DERYA DEMİRDİZEN ÇEVİK","DERYA DEMİRDİZEN ÇEVİK","","",""

    };
//for Salon 6
    private String[] txt_title3  ={
            "ABDÜLKADİR ÇAKIR, HALİS SİPAHİ, HARUN GÜMÜŞ, HASAN TEZCAN, SEYİT AKPANCAR (9908)","ABDÜLKADİR ÇAKIR, ERHAN KURTTEKİN, FEVZİ SEZGİN SEÇKİN, SEYİT AKPANCAR (9910)",
            "MEHTAP ÖZENEN KAVLAK, ADEM KURTİPEK, SAYE NİHAN ÇABUK (9970)","ABDOUL AZIZ RAZIKOU DILWANI, ÖMER ÖZGÜR TANRIÖVER (9780)","NUR SİNEM PARTİGÖÇ, ÇİĞDEM TARHAN (9884)","",

            "OYA AÇIKALIN, NİLGÜN OKAY, GÜL YÜCEL, EBRU İNAL (9889)","EZGİ DADAŞ, ZEYNEP YEŞİM İLERİSOY (9895)","ELMAS UZUNER, NİLÜFER AKINCITÜRK (9816)","PINAR KISA OVALI, CENK MOTOR (9853)",
            "FIRAT ASLANGİRİ, OYA AÇIKALIN RASHEM (9277)",

            "MURAT ACAR (9093)","ÖNDER DEMİR, ZEYNEP ORTAKAVAK, SAYE NİHAN ÇABUK, ALPER ÇABUK (9733)","OSMAN DUMAN, MEHMET MERDAN (9735)","HACI AHMET KIRTAŞ, HÜSEYİN ALTUNDAĞ (9788)","",""

    };

    private String[] txt_konu3 = {
            "KARBONMONOKSİT GAZ SENSÖR TASARIMI VE SABİT TELEFON ARAMALI ALARM SİSTEMİ\n" +
                    "CARBONMONOXİDE GAS SENSOR DESİGN AND ALARM SYSTEM WİTH PHONE CALL","ANDROİD ERİŞİMLİ SOLAR ENERJİ DESTEKLİ ZİRAİ ÖRTÜ SİSTEMİ\n" +
            "ANDROİD ACCESS SOLAR ENERGY SUPPORTED AGRİCULTURAL COVERİNG SYSTEM","KÜTAHYA TÜRKMEN ORMAN İŞLETME ŞEFLİĞİ ORMANLIK ALANLARI İÇİN COĞRAFİ BİLGİ SİSTEMLERİ İLE ORMAN YANGINI TEHLİKE HARİTASI OLUŞTURULMASI\n" +
            "THE PREPARATION OF FOREST FIRE HAZARD MAPS USING GEOGRAPHICAL INFORMATION SYSTEMS CAPABILITIES FOR TÜRKMEN FOREST MANAGEMENT UNIT - KÜTAHYA","GÜNCEL MAKİNE ÖĞRENMESİ TAHMİN MODELLERİ İLE HASTANEYE YATIŞ VE ACİLİYET SINIFI TAHMİNİ Emergency triage and hospitalization prediction with state of the art machine learning models",
            "Dijital Çağda Afet Yönetimi: Dijital Bölünme Perspektifinden Bir İnceleme Disaster Management in the Digital Age: A Review from Digital Divide Perspective",
            "",

            "AFET DİRENÇLİLİĞİ BAKIMINDAN ERİŞİLEBİLİR GEÇİCİ BARINMA\n" +
                    "ACCESSİBLE TEMPORARY SHELTER FOR DİSASTER RESİLİENCE","AFET SONRASI GEÇİCİ BARINMA BİRİMLERİNDE GÜNCEL MİMARİ TASARIM VE YAPIM TEKNOLOJİLERİNİN DEĞERLENDİRİLMESİ\n" +
            "EVALUATION OF CURRENT ARCHITECTURAL DESIGN AND CONSTRUCTION TECHNOLOGIES IN POST-DISASTER SHELTER DESIGNS","DEPREM SONRASI KONUTLARIN YENİDEN PLANLAMA SORUNSALINA BÜTÜNCÜL BİR BAKIŞ: KOCAELİ/ GÖLCÜK ÖRNEĞİ\n" +
            "AN INTEGRATED VİEW TO RE-PLANNİNG PROBLEM İN HOUSİNG POST-EARTHQUAKE: EXAMPLE OF KOCAELİ/ GÖLCÜK\n","İKLİM DEĞİŞİKLİĞİ VE DİRENÇLİLİK: DİRENÇLİ TASARIM İLKELERİ VE YEREL MİMARİ\n" +
            "CLIMATE CHANGE AND RESILIENCE: PRINCIPLES OF RESILIENT DESIGN AND VERNACULAR ARCHITECTURE","VAN’IN KÖYLERİ 2011 DEPREMLERİNDEN BU YANA DAYANIKLILIK HEDEFİNE NE KADAR YAKLAŞABİLDİLER?\n" +
            "HOW RESILIENT HAVE THE VILLAGES OF VAN BECOME SINCE THE 2011 EARTHQUAKES? THE CASE OF TEN VILLAGES\n",

            "AFET VE ACİL DURUMLARDA ÖZEL GEREKSİNİMLİ BİREYLERLE KURULACAK İLETİŞİME YÖNELİK İYİ BİR YÖNETİŞİM UYGULAMASI: BEYLİKDÜZÜ ÖRNEĞİ\n" +
                    "A GOOD GOVERNANCE PRACTICE FOR COMMUNICATION WITH SPECIAL NEEDS INDIVIDUALS IN DISASTERS AND EMERGENCIES: BEYLİKDÜZÜ EXAMPLE\n","SOSYAL KIRILGANLIK İNDEKSİNİN HARITALANABİLMESİ İÇİN GEREKLİ VERİ TOPLAMA SİSTEMİ\n" +
            "DATA COLLECTION SYSTEM FOR MAPPING OF SOCIAL VULNERABILITY INDEX","AFET YÖNETİMİNDE ARDUİNO GELİŞTİRME KARTI İLE YAPILAN ÇALIŞMALARIN İNCELENMESİ\n" +
            "INVESTİGATİON OF ARDUİNO DEVELOPMENT CARD STUDİES İN DİSASTER MANAGEMENT","ÖZEL GEREKSİNİMLİ BİREYLERİN ACİL DURUM ANINDA YER TESPİTİ VE BİNA TAHLİYESİ\n" +
            "EMERGENCY DETERMINATION AND BUILDING DISPOSAL OF SPECIAL NEEDS","",""

    };

    private String[] oturum_baskan3 = {
            "MEHTAP ÖZENEN KAVLAK","MEHTAP ÖZENEN KAVLAK","MEHTAP ÖZENEN KAVLAK","MEHTAP ÖZENEN KAVLAK","MEHTAP ÖZENEN KAVLAK","MEHTAP ÖZENEN KAVLAK",

            "nilgün okay","nilgün okay","nilgün okay","nilgün okay","nilgün okay",

            "SAYE NİHAN ÇABUK","SAYE NİHAN ÇABUK","SAYE NİHAN ÇABUK","SAYE NİHAN ÇABUK","",""

    };
//for Salon 7
    private String[] txt_title4  ={
            "YUSUF GÜNER, OSMAN FURKAN ERGÜN, BEKTAŞ SARI (9440)","SAVAŞ ÇAĞLAK, MUHAMMET BAHADIR, FATİH IŞIK (9762)","MEHMET EMİN CİHANGİR (9798)","TALHA AKSOY, SERHAT SARI, ALPER ÇABUK (9947)\n",
            "SERHAT SARI, TALHA AKSOY, ALPER ÇABUK (9948)","GORDANA KAPLAN, ZEHRA YIGIT AVDAN, UGUR AVDAN, TATJANA JOVANOVSKA (9636)",

            "HALİL İBRAHİM ÇİÇEKDAĞI, FATİME ÖKENEK, YILDIZ TOSUN (9703)","GÖZDE İKİZER, AYŞE NURAY KARANCI, CANAY DOĞULU (9821)","BEKTAŞ SARI, OSMAN FURKAN ERGÜN, YUSUF GÜNER (9925)",
            "SÜMEYYE KAHRAMAN, ERKAN POLAT (9870)","",

            "BAHATTİN MURAT DEMİR (9451)","GÜLİZ MÜGE AKPINAR (9791)","ZEYNEP SOFUOĞLU (9877)","HALİME KÜÇÜK, NURDAN ACAR, İLKER ŞEN (9929)","",""
    };

    private String[] txt_konu4 = {
            "KÜRESEL İKLİM DEĞİŞİKLİĞİ VE AFETE DİRENÇLİ TOPLUM\n" +
                    "GLOBAL CLİMATE CHANGE AND DİSASTER RESİLİENT COMMUNİTİES","BİYOKLİMATİK KONFOR ŞARTLARININ YAŞLI NÜFUS AÇISINDAN İNCELENMESİ; SİNOP ÖRNEĞİ\n" +
            "INVESTİGATİON OF BİOCLİMATİC COMFORT CONDİTİONS IN TERMS OF ELDERLY POPULATİON; SİNOP EXAMPLE","YAMAÇ ÜNİTELERİNE GÖRE MEKANSAL HEYELAN HASSASİYETİNİN DEĞERLENDİRMESİ\n" +
            "ASSESSMENT SPATİAL LANDSLİDE SENSİTİVİTY ACCORDİNG TO SLOPE UNİTS\n","RÜZGAR TÜRBİNLERİNİN VEJETASYON ÜZERİNDEKİ ETKİLERİ VE PEYZAJ DİRENÇLİLİĞİ: URLA, ÇEŞME, KARABURUN YARIMADALARI ÖRNEKLEMİ\n" +
            "THE EFFECTS OF WİND TURBİNES ON VEGETATİON AND LANDSCAPE RESİSTANCE: URLA, ÇEŞME, KARABURUN PENİNSULA SAMPLE\n","SUYUN SÜRDÜRÜLEBİLİRLİĞİ VE DİRENÇLİLİK, ÖRNEKLEME ALANI: BURDUR GÖLLER YÖRESİ\n" +
            "SUSTAİNABİLİTY AND RESİLİENCE OF WATER, STUDY CASE: BURDUR LAKE REGİON","UZAKTAN ALGILAMA TEKNİKLERİYLE ULUSLARARASI SULARIN İZLENMESİ: DOJRAN GÖLÜ ÖRNEĞİ\n" +
            "REMOTE SENSİNG TECHNİQUES FOR MONİTORİNG SHARED İNTERNATİONAL WATERS; STUDY CASE - DOJRAN LAKE",

            "AFET VE ACİL DURUM ÇALIŞANLARININ STRESLE BAŞA ÇIKMA YÖNTEMLERİNİN ÇALIŞMA SİNERJİLERİ ÜZERİNE ETKİLERİ VE BİR UYGULAMA ÇALIŞMASI\n" +
                    "THE EFFECTS OF STRESS-COPING METHODS ON WORKING SYNERGY FOR DISASTER AND EMERGENCY WORKERS AND AN APPLICATION STUDY\n","AFET DİRENÇLİLİĞİNİ ARTIRAN KAYNAKLAR VE KAPASİTELER: AVRUPA’DAN VAKA ÇALIŞMALARI VE ÖRNEKLER\n" +
            "RESOURCES AND CAPACITIES INCREASING DISASTER RESILIENCE: CASE STUDIES AND EXAMPLES FROM EUROPE","AFETLERE KARŞI DİRENÇLİ TOPLUM OLUŞTURMA SÜRECİNİN KAVRAMSALLAŞTIRILMASI ÜZERİNE BİR ÇALIŞMA\n" +
            "A STUDY ON THE CONCEPTUALIZATION OF DISASTER RESILIENT SOCIETIES\n","METEOROLOJİK KAYNAKLI AFETLERE BİR KARŞI DURUŞ: DİRENÇLİ PLANLAMA\n" +
            "AN STANCE AGAINST TO METEOROLOGICAL DISASTERS: RESILIENT PLANNING","",

            "DİRENÇLİLİK PERSPEKTİNDEN TÜRKİYE’DE ASBEST YÖNETİMİ\n" +
                    "MANAGEMENT OF ASBESTOS IN TURKEY FROM THE PERSPECTIVE OF RESISTANCY","İŞ GÜVENLİĞİ İKLİMİNİ ETKİLEYEN FAKTÖRLERİN İNCELENMESİ: AYDIN İLİ İNŞAAT SEKTÖRÜ ÖRNEĞİ\n" +
            "THE ANALYSIS OF FACTORS AFFECTING OCCUPATIONAL SAFETY CLIMATE: THE SAMPLE OF CONSTRUCTION SECTOR OF AYDIN\n","İZMİR ATATÜRK ORGANİZE BÖLGESİ'NDE BULUNAN İŞYERLERİNİN ACİL DURUMLARA YÖNELİK HAZIRLIĞININ DEĞERLENDİRİLMESİ\n" +
            "EVALUATİON OF EMERGENCY PREPAREDNESS OF WORKPLACES İN IZMİR ATATURK ORGANİZED INDUSTRİAL REGİON","HASTANELERDE TAHLİYE GEREKLERİNİN YÖNETMELİK KAPSAMINDA DEĞERLENDİRİLMESİ\n" +
            "ASSESSMENT OF HOSPİTAL EVACUATİON İN TERMS OF REGULATİONS","",""

    };

    private String[] oturum_baskan4 = {
            "UĞUR AVDAN","UĞUR AVDAN","UĞUR AVDAN","UĞUR AVDAN","UĞUR AVDAN","UĞUR AVDAN",

            "BEKTAŞ SARI","BEKTAŞ SARI","BEKTAŞ SARI","BEKTAŞ SARI","",

            "HALİME KÜÇÜK","HALİME KÜÇÜK","HALİME KÜÇÜK","HALİME KÜÇÜK","",""

    };
//for Salon 8
    private String[] txt_title5  ={
            "HAZEL ÖZGE DOĞAN (10042)","SÜMEYYE KAHRAMAN, ERKAN POLAT, BURAK KORKMAZYÜREK (10056)","ELİF NUR SARI, SEVGİ YILMAZ (10057)","OZAN HOVARDAOĞLU, SEDA ÇALIŞIR HOVARDAOĞLU (10079)",
            "PİNAR SARACOGLU (10097)","ASLI AKAY (9900)",

            "ÖZGÜR AVŞAR (9100)","SİNEM OKTAY, NİLÜFER TAŞ, MURAT TAŞ (9744)","BİRSEN YÜCESES, C.NAKIŞ KARAMAĞARALI, Z.GEDİZ URAK (9847)","EMRE BECERİR, EMRE KİSHALİ (9860)", "",

            "BENGÜ AYDIN DİKMEN (9501)","HACI AHMET KIRTAŞ, HÜSEYİN ALTUNDAĞ (9790)","EBRU TEKIN BILBIL (9823)","R.ÖZGÜN KEHYA (9941)","",""


    };

    private String[] txt_konu5 = {
            "İMAR BARIŞI’NIN KENTSEL DÖNÜŞÜM VE AFETLER KAPSAMINDA DEĞERLENDİRİLMESİ\n" +
                    "EVALUATİON OF ZONİNG PEACE WİTHİN THE SCOPE OF URBAN RENEWAL AND DİSASTERS","KENTSEL DİRENÇLİLİK KAVRAMI ÜZERİNE BİR ARAŞTIRMA\n" +
            "A RESEARCH ON THE CONCEPT OF URBAN RESILIENCE","FARKLI KONUT DOKULARINDA CADDE ÖLÇEĞİNDE HAVA KİRLİLİĞİ ANALİZİ\n" +
            "ANALYSİS OF AİR POLLUTİON ON STREET SCALE İN DİFFERENT HOUSİNG PATTERN","KAMU YARARI, YAŞAM KALİTESİ VE KENTLEŞME İLKESİ OLARAK KENTSEL DİRENÇLİLİK\n" +
            "URBAN RESİLİENCE AS PUBLİC INTEREST, QUALİTY OF LİFE AND AN URBANİZATİON PRİNCİPLE\n","İSTANBUL’DAKİ SOSYO-EKONOMİK KIRILGANLIKLARA DAİR BÜTÜNCÜL BİR DEĞERLENDİRME\n" +
            "A HOLİSTİC EVALUATİON ON SOCİO-ECONOMİC VULNERABİLİTİES İN ISTANBUL\n","SENDAİ AFET RİSKLERİNİN AZALTILMASI ÇERÇEVESİNDE (2015-2030) DİRENÇLİ KENTLERİ OLUŞTURMAK\n" +
            "BUILDING RESILIENCE CITIES IN THE SENDAI DISASTER RISK REDUCTION FRAMEWORK (2015-2030)\n",

            "TOPLUMUN DEPREM BİLİNCİNİN GELİŞTİRİLMESİNDE DEPREM MÜZELERİNİN ÖNEMİ: TAYVAN ÖRNEĞİ\n" +
                    "IMPORTANCE OF EARTHQUAKE MUSEUMS TO INCREASE PUBLİC AWARENESS: THE TAİWAN EXAMPLE","KÜLTÜREL MİRAS ALANLARINDA AFET YÖNETİMİ\n" +
            "DISASTER MANAGEMENT IN CULTURAL HERITAGE AREAS\n","TOKAT İLİ KALELERİNİN KORUMA SÜREÇLERİNİN KORUMA İLKELERİ KAPSAMINDA İNCELENMESİ\n" +
            "ASSESMENT OF DOCUMENTATİON PROCESSES OF CASTLES OF TOKAT, İN THE CONTEXT OF ARCHİTECTURAL CONSERVATİON PRİNCİPLES\n","KIRSAL MİRASIN DEĞİŞİM VE DÖNÜŞÜMÜ ÜZERİNE NEVŞEHİR KALE ETRAFI YERLEŞKESİ\n" +
            "CHANGE AND TRANSFORMATİON OF RURAL HERİTAGE NEVŞEHİR CASTLE SURROUNDİNGS","",

            "Mahalle bostanları, yurttaşlık kültürü ve iklim tehlikelerine dirençlilik: imkân ve kısıtlılıklar\n" + "Community gardens, civic culture and resilience against climate hazards: potentials and limitations",
            "YANGIN MÜDAHALESİNDE LOJİSTİK LOGİSTİCS İN FİRE RESPONSE",
            "Resilience ve Belirsizlik: Sosyo-ekoloji ve kentsel ortam/alan Resilience and Uncertainty: Socio-ecologies and urban milieu/space",
            "AFAD Web Sitesindeki Videoların Afet İletişimi Bağlamında Nicel Analizi Quantitative Analysis of Videos in AFAD Web Site in the Context of Disaster Communication",
            "",""
    };

    private String[] oturum_baskan5 = {
            "DENİZ GERÇEK KURT","DENİZ GERÇEK KURT","DENİZ GERÇEK KURT","DENİZ GERÇEK KURT","DENİZ GERÇEK KURT","DENİZ GERÇEK KURT",

            "ÖZGÜR AVŞAR","ÖZGÜR AVŞAR","ÖZGÜR AVŞAR","ÖZGÜR AVŞAR","",

            "","","","","",""


    };
//for Salon 9
    private String[] txt_title6  ={
            "FATİH BOZKURT, ÖZER AYDIN (9989)","SEVGİ İNECİ (10059)","BURAK GÖRGÜN, NAZİLE URAL (10077)","SELÇUK NAM, DİLEK NAM (10085)","","",

            "SALAD ABDLLAHİ, GÖKHAN DEMİR, UTKU KÖKTAN, MUZAFFER KEREM ERTEK (9741)","NURİ YILMAZ, HASAN BOZKURT, YILDIRIM BAYAZIT (9757)","GÖKHAN DEMİR, ÖMER FATİH YAZICI, MUZAFFER KEREM ERTEK, UTKU KÖKTAN (9742)",
            "RUSTAM QAZIZADA, GÖKHAN DEMİR, UTKU KÖKTAN, MUZAFFER KEREM ERTEK (9937)","",

            "","","","","",""
    };

    private String[] txt_konu6 = {
            "RAY – TEKER ARASINDA MEYDANA GELEN KIVILCIMLARIN SEBEP OLDUĞU YANGINLARIN ÖNLENMESİ\n" +
                    "PREVENTİNG FİRES CAUSED BY SPARKS OCCURRİNG BETWEEN THE RAİL AND THE WHEEL","SEL RİSKİ ALTINDAKİ ALANLARDA KOBİ’LERİN AFET ÖNCESİ HAZIRLIKLARI: BİR SAHA ALAN ÇALIŞMASI\n" +
            "EARLY PREPAREDNESS OF SMES UNDER FLOODİNG THREAT: A CASE STUDY ANALYSİS","AŞIRI KONSOLİDASYON ORANI FARKLI KİL ZEMİNLERDE TÜNEL DEFORMASYONLARININ SONLU ELEMANLAR YÖNTEMİYLE BELİRLENMESİ\n" +
            "DETERMİNATİON OF TUNNEL DEFORMATİONS ON DİFFERENT OVER CONSOLİDATİON RATİO OF CLAY SOİLS BY FİNİTE ELEMENT METHOD","GÜVENLİK KÜLTÜRÜ ALGISININ İŞ KAZALARI ÜZERİNDEKİ ETKİSİ; OTOMOTİV SEKTÖRÜNDE BİR DURUM ÇALIŞMASI\n" +
            "IMPACT OF SAFETY CULTURE PERCEPTİON ON WORK ACCİDENTS; A CASE STUDY İN THE AUTOMOTİVE SECTOR","","",

            "DARBELİ KIRMATAŞ KOLONLAR İLE İYİLEŞTİRİLMİŞ ZEMİNLERİN SİSMİK YÜKLER ALTINDAKİ DAVRANIŞININ İNCELENMESİ\n" +
                    "INVESTIGATION OF THE BEHAVIOR OF IMPROVED SOILS WITH RAMMED AGGREGATE PIERS UNDER SEISMIC LOADS","MEVCUT AKARSU KÖPRÜLERİNİN TAŞKINLARA KARŞI KORUNMASINA YÖNELİK DEĞERLENDİRMELER: FİDANLIK KÖPRÜSÜ ÖRNEĞİ\n" +
            "EVALUATİONS ON PROTECTİON OF EXİSTİNG RİVER BRİDGES AGAİNST FLOODS: A CASE STUDY FİDANLIK BRİDGE","ŞEV STABİLİTESİNE DEPREM ETKİSİNİN SONLU ELEMANLAR YÖNTEMİYLE İNCELENMESİ: KARABÜK/YENİCE ÖRNEĞİ\n" +
            "EXAMINATION OF EARTHQUAKE EFFECTS ON THE SLOPE STABILITY BY FINITE ELEMENT METHOD: KARABÜK/YENİCE EXAMPLE","RÜZGAR TÜRBİN TEMELİNİN DİNAMİK YÜKLER ALTINDAKİ DAVRANIŞININ İNCELENMESİ\n" +
            "INVESTIGATION OF THE BEHAVIOUR OF WIND TURBINE FOUNDATION UNDER SEISMIC LOADS","",

            "","","","","",""
    };

    private String[] oturum_baskan6 = {
            "FATİH BOZKURT","FATİH BOZKURT","FATİH BOZKURT","FATİH BOZKURT","","",

            "NURİ YILMAZ","NURİ YILMAZ","NURİ YILMAZ","NURİ YILMAZ","",

            "ÖZGÜM KEHYA","ÖZGÜM KEHYA","ÖZGÜM KEHYA","ÖZGÜM KEHYA","",""

    };
//for Salon 10
    private String[] txt_title7  ={
            "CENGİZ İPEK (9520)","AHMET ÖZDEMİR, SERPİL GERDAN (9825)","ERTAN TURGU, ALİ ÜMRAN KÖMÜŞÇÜ, YUSUF ZİYA YAVUZ, BAHATTİN AYDIN (9854)","UMUT PEKİN TİMUR, ÖZGÜR BURHAN TİMUR, SAİD HASSAN MAHAMAD (9919)",
            "EYÜP ÇATLI, SERPİL GERDAN (10121)","ALİ EKŞİ (9463)",

            "CAFER YILDIRIM (9279)","DENİZ KARABALIK (9858)","İSMAİL TALİH GÜVEN, DENİZ GERÇEK KURT (10192)","","",

            "","","","","",""
    };

    private String[] txt_konu7 = {
            "KOCAELİ AFET ALGISININ ANALİZİ\n" +
                    "ANALYSIS OF KOCAELİ DISASTER PERCEPTION\n","AFET SONRASI TOPLANMA ALANINA DÖNÜŞEBİLEN MİLLET BAHÇELERİ\n" +
            "NATIONAL GARDENS CONVERTIBLED AS ASSEMBLY POINT AFTER DISASTER","AFETLERE BİR DİRENÇLİLİK ÖRNEĞİ: MERSİN İLİ TARSUS İLÇESİNDE 04 OCAK 2018 TARİHİNDE MEYDANA GELEN ANİ TAŞKININ FFGS ÜRÜNLERİ İLE ANALİZİ\n" +
            "AN EXAMPLE OF RESISTANCE TO DISASTERS:ANALYSİS OF FLASH FLOOD USİNG FFGS PRODUCTS ON 04 JAN 2018 İN TARSUS\n","TAŞKIN KORUMADA YEŞİL YOLLARIN ÖNEMİNİN DEĞERLENDİRİLMESİ\n" +
            "EVALUATİON OF THE IMPORTANCE OF GREENWAYS İN FLOOD PROTECTİON","PRES MAKİNALARININ KURULUM RİSKLERİNİN İŞ GÜVENLİĞİ AÇISINDAN DEĞERLENDİRİLMESİ\n" +
            "EVALUATION OF INSTALLATION RISKS OF PRESS MACHINES IN TERMS OF WORK SAFETY","Üniversite Öğrencilerinde Afetlere Karşı Bireysel Direnci Etkileyen Faktörlerin Değerlendirilmesi Evaluation of Factors Affecting Individual Resistance to Disasters in University Students",

            "AFET VE ACİL DURUMLARDA İLAÇ RİSK YÖNETİMİ\n" +
                    "DRUG RİSK MANAGEMENT İN DİSASTER AND EMERGENCY CASES\n","AFETLERDE KRONİK HASTALIKLAR VE BESLENME CHRONIC DISEASES AND NUTRITION IN DISASTERS",
            "İZMİT KENTİNDE KONUT STOKUNUN DEPREME KARŞI ‘ALGILANAN RİSK’İ VE YERBİLİMLERİ RİSK VERİSİNİN KARŞILAŞTIRMASI COMPARİSON OF ‘PERCEİVED RİSK’ OF HOUSİNG STOCK AGAİNST EARTHQUAKE AND THE EARTHQUAKE RİSK FROM EARHTSCİENCES DATA İN İZMİT CİTY",
            "","",

            "","","","","",""
    };

    private String[] oturum_baskan7 = {
            "SERPİL GERDAN","SERPİL GERDAN","SERPİL GERDAN","SERPİL GERDAN","SERPİL GERDAN","",

            "DENİZ KARABALIK","DENİZ KARABALIK","DENİZ KARABALIK","","",

            "","","","","",""

    };
//for Salon 11
    private String[] txt_title8  ={
            "ALİ TOPAL, MUHİTTİN DEMİRKASIMOĞLU (9695)","İLKNUR MAYA, MUSTAFA GÖKBAYRAK (9713)","RABİA DAĞDAŞ (9716)","EMİNE AKTAŞ, Emrah GÜNEY, Mesut KAZAN, Tülin ÇEVİKEL, Seval KOLDAŞ, Mehmet İbrahim TUĞLU (9783)","", "",

            "BÜŞRA GİZEM YILMAZ (9510)","ALPER BODUR (9682)","FADİ ORFALİ, ABDULLAH DİLSİZ, SALAH HAJ ISMAIL (9747)","","",

            "","","","","",""
    };

    private String[] txt_konu8 = {
            "T.C. SAĞLIK BAKANLIĞI ULUSAL MEDİKAL KURTARMA EKİBİ (UMKE) ÇALIŞANLARINDA ALGILANAN STRES DÜZEYLERİ ÜZERİNDE OTANTİK LİDERLİK DAVRANIŞLARI ETKİSİNİN İNCELENMESİ: İSTANBUL İLİ ÖRNEĞİ EXAMINING THE EFFECT OF AUTHENTIC LEADERSHIP BEHAVIORS ON PERCEIVED STRESS LEVELS IN NATIONAL MEDICAL RESCUE TEAM (UMKE) WORKERS IN THE MINISTRY OF HEALTH: EXAMPLE OF İSTANBUL",
            "AFETLERE DİRENÇLİLİKTE EDİRNE 112 ÇALIŞANLARININ AFET HAZIRLIKLARI VE AFET BİLİNÇ DÜZEYLERİ DISASTER PREPAREDNESS DİRENÇLİLİKTE EDİRNE 112 HEALTH WORKERS DISASTER PREPARATION and DISASTER AWARENESS LEVELS",
            "Afetler Sırasında Hasta ve Yaralılara Müdahalede Sığınak Görevi Yapan Yer Altı Hastanelerine Genel Bir Bakış A General Overwiew of Underground Hospitals Acting as Shelter in İntervention to Patients and Wounded During Disasters",
            "AFETİN SAĞLIK KAHRAMANLARI, ULUSAL MEDİKAL KURTARMA EKİBİ; MANİSA UMKE AFET DENEYİMLERİ\n" + "DISASTER HEALTH HEROES, NATIONAL MEDICAL RESCUE TEAM; MANISA UMKE DISASTER EXPERIENCES",
            "","",

            "OYUN PARKINDAN KENT PARKINA:SENGEL FİKİR PROJESİ\n" +
                    "FROM THE PLAYGROUND TO THE PUBLİC PARK: SENGEL IDEA PROJECT","TÜRKİYE’DE MİMARLIK VE İÇ MİMARLIK ÖĞRETİMİNDE YANGIN GÜVENLİĞİNİN YERİ\n" +
            "THE ROLE OF FIRE SAFETY IN ARCHITECTURE AND INTERIOR DESIGN EDUCATION IN TURKEY","URBAN PLANNİNG, ARCHİTECTURE, DİSASTER RESPONSE, ISTANBUL\n" +
            "CODE OF CONDUCT İN DİSASTER RESPONSE URBAN AND ARCHİTECTURAL PLANNİNG PERSPECTİVE İN ISTANBUL","","",

            "","","","","",""
    };

    private String[] oturum_baskan8 = {
            "MUHİTTİN DEMİRKASIMOĞLU","MUHİTTİN DEMİRKASIMOĞLU","MUHİTTİN DEMİRKASIMOĞLU","MUHİTTİN DEMİRKASIMOĞLU","MUHİTTİN DEMİRKASIMOĞLU","MUHİTTİN DEMİRKASIMOĞLU",

            "ALPER BODUR","ALPER BODUR","ALPER BODUR","","",

            "","","","","",""

    };
//for Salon 12
    private String[] txt_title9  ={
            "BERKAY ÖZKAY, SÜHEYLA YEREL KANDEMİR, EMİN AÇIKKALP (9574)","BURAK YAPRAK, SELİM YAZICI (9913)","BURAK YAPRAK, SELİM YAZICI (9906)","","","",

            "ZEYNEP FİKRAN YENİCE (9497)","ABDELHAMED BARANI (9620)","AYLİN SENTURK (9755)","VESİLE ÖZEN, ŞERİFE BETÜL ÇETİNKAYA (9808)","",

            "","","","","",""
    };

    private String[] txt_konu9 = {
            "TÜRKİYE’DE MADEN SEKTÖRÜNDEKİ İŞ KAZALARININ İNCELENMESİ INVESTIGATION OF WORK ACCIDENTS IN MINING SECTOR IN TURKEY",
            "ORGANİZASYON TEORİLERİ PERSPEKTİFİNDEN İŞ SÜREKLİLİĞİ YÖNETİMİ Business Continuity Management from An Organizational Theory Perspective",
            "Türkiye’deki KOBİ’lerin İş Sürekliliği Yönetimi Konusundaki Farkındalık Düzeylerinin Belirlenmesi Determining the Level of Business Continuity Management Awareness of SMEs in Turkey",
            "","","",

            "TÜRKİYE’DE KIŞ TURİZMİ MERKEZLERİNİN İKLİM DEĞİŞİKLİĞİNE DAYANIKLILIĞININ DEĞERLENDİRİLMESİ, BOLU KÖROĞLU DAĞI VE ERZURUM PALANDÖKEN ÖRNEKLERİ\n" +
                    "CLİMATE CHANGE RESILIENCE ASSESMENT OF WINTER TOURISM CENTERS IN TURKEY: BOLU KÖROĞLU AND ERZURUM PALANDÖKEN\n","SAVAŞ ALTINDAKİ KENTİN KIRILGANLIKLARI VE DİRENÇLİLİK STRATEJİLERİ: BENGAZİ KENTİNDE BİR VAKA ÇALIŞMASI\n" +
            "VULNERABILITIES AND RESILIENCE STRATEGIES OF A CITY UNDER WAR: A CASE STUDY IN BENGHAZI","KULLANICI SÜREKLİLİĞİNİN KENTSEL KORUMA VE TOPLUMSAL DAYANIKLILIK ÜZERİNDEKİ ETKİSİ\n" +
            "İMPACT OF USER CONTİNUİTY ON URBAN CONSERVATİON AND COMMUNİTY RESİLİENCE","AFET RİSKİ NEDENİYLE DÖNÜŞEN KENTSEL ALANLARDA KONUT PİYASASI FAKTÖRÜ: KEPEZ-SANTRAL BÖLGESİ KENTSEL DÖNÜŞÜM PROJESİ ÖRNEĞİ\n" +
            "HOUSING MARKET FACTOR IN URBAN AREAS THAT TRANSFORMING DUE TO DİSASTER: THE CASE OF KEPEZ-SANTRAL REGION URBAN TRANSFORMATION PROJECT\n","",

            "","","","","",""
    };

    private String[] oturum_baskan9 = {
            "UISFED TEMSİLCİSİ","UISFED TEMSİLCİSİ","UISFED TEMSİLCİSİ","UISFED TEMSİLCİSİ","","",

            "VESİLE ÖZEN","VESİLE ÖZEN","VESİLE ÖZEN","VESİLE ÖZEN","",

            "","","","","",""
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_tab3, container, false);

        btn3 = inflate.findViewById(R.id.btn3_1); //Salon3
        btn4 = inflate.findViewById(R.id.btn3_14); //Salon4
        btn5 = inflate.findViewById(R.id.btn3_2);  //Salon5
        btn6 = inflate.findViewById(R.id.btn3_3);  //Salon6
        btn7 = inflate.findViewById(R.id.btn3_4);  //Salon7
        btn8 = inflate.findViewById(R.id.btn3_5);  //Salon8
        btn9 = inflate.findViewById(R.id.btn3_6);  //Salon9
        btn10 = inflate.findViewById(R.id.btn3_7);  //Salon10
        btn11 = inflate.findViewById(R.id.btn3_8);  //Salon11
        btn12 = inflate.findViewById(R.id.btn3_9);  //Salon12
        title = inflate.findViewById(R.id.title3_salon);

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

        Tab1Adapter tab1Adapter = new Tab1Adapter(getActivity(),txt_clock,txt_title);
        listView = inflate.findViewById(R.id.list_tab3);
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
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                }else if(position == 3){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                }else if(position == 10){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                }else if(position == 11){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                }else if(position == 12){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                }else if(position == 13){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                }else if(position == 14){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                }else if(position == 15){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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
                }else if(position == 16){

                    Intent go_details = new Intent(getActivity(),Details.class);
                    if(clilcked_btn.equals("Salon 3")) {
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu[position]);
                        go_details.putExtra("baskan",oturum_baskan[position]);
                    }else if(clilcked_btn.equals("Salon 4")){
                        go_details.putExtra("clock", txt_clock[position]);
                        go_details.putExtra("speakers", txt_title14[position]);
                        go_details.putExtra("salon",clilcked_btn);
                        go_details.putExtra("konu",txt_konu14[position]);
                        go_details.putExtra("baskan",oturum_baskan14[position]);
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


            case R.id.btn3_1:
                //Salon 3
                title.setText(getString(R.string.salon3));
                clilcked_btn = getString(R.string.salon3);

                Tab1Adapter tab1Adapter = new Tab1Adapter(getActivity(),txt_clock,txt_title);
                listView = inflate.findViewById(R.id.list_tab3);
                listView.setAdapter(tab1Adapter);

                break;

            case R.id.btn3_2:
                //Salon 5
                title.setText(R.string.salon5);
                clilcked_btn = getString(R.string.salon5);

                Tab1Adapter tab1Adapter2 = new Tab1Adapter(getActivity(),txt_clock,txt_title2);
                listView = inflate.findViewById(R.id.list_tab3);
                listView.setAdapter(tab1Adapter2);

                break;

            case R.id.btn3_3:
                //Salon 6
                title.setText(R.string.salon6);
                clilcked_btn = getString(R.string.salon6);

                Tab1Adapter tab1Adapter3 = new Tab1Adapter(getActivity(),txt_clock,txt_title3);
                listView = inflate.findViewById(R.id.list_tab3);
                listView.setAdapter(tab1Adapter3);

                break;

            case R.id.btn3_4:
                //Salon 7
                title.setText(R.string.salon7);
                clilcked_btn = getString(R.string.salon7);

                Tab1Adapter tab1Adapter7 = new Tab1Adapter(getActivity(),txt_clock,txt_title4);
                listView = inflate.findViewById(R.id.list_tab3);
                listView.setAdapter(tab1Adapter7);

                break;

            case R.id.btn3_5:
                //Salon 8
                title.setText(R.string.salon8);
                clilcked_btn = getString(R.string.salon8);

                Tab1Adapter tab1Adapter8 = new Tab1Adapter(getActivity(),txt_clock,txt_title5);
                listView = inflate.findViewById(R.id.list_tab3);
                listView.setAdapter(tab1Adapter8);

                break;

            case R.id.btn3_6:
                //Salon 9
                title.setText(R.string.salon9);
                clilcked_btn = getString(R.string.salon9);

                Tab1Adapter tab1Adapter9 = new Tab1Adapter(getActivity(),txt_clock,txt_title6);
                listView = inflate.findViewById(R.id.list_tab3);
                listView.setAdapter(tab1Adapter9);

                break;

            case R.id.btn3_7:
                //Salon 10
                title.setText(R.string.salon10);
                clilcked_btn = getString(R.string.salon10);

                Tab1Adapter tab1Adapter10 = new Tab1Adapter(getActivity(),txt_clock,txt_title7);
                listView = inflate.findViewById(R.id.list_tab3);
                listView.setAdapter(tab1Adapter10);

                break;

            case R.id.btn3_8:
                //Salon 11
                title.setText(R.string.salon11);
                clilcked_btn = getString(R.string.salon11);

                Tab1Adapter tab1Adapter11 = new Tab1Adapter(getActivity(),txt_clock,txt_title8);
                listView = inflate.findViewById(R.id.list_tab3);
                listView.setAdapter(tab1Adapter11);

                break;

            case R.id.btn3_9:
                //Salon 12
                title.setText(R.string.salon12);
                clilcked_btn = getString(R.string.salon12);

                Tab1Adapter tab1Adapter12 = new Tab1Adapter(getActivity(),txt_clock,txt_title9);
                listView = inflate.findViewById(R.id.list_tab3);
                listView.setAdapter(tab1Adapter12);

                break;

            case R.id.btn3_14:
                //Salon 4
                title.setText(R.string.salon4);
                clilcked_btn = getString(R.string.salon4);

                Tab1Adapter tab1Adapter14 = new Tab1Adapter(getActivity(),txt_clock,txt_title14);
                listView = inflate.findViewById(R.id.list_tab3);
                listView.setAdapter(tab1Adapter14);

                break;
        }
    }
}

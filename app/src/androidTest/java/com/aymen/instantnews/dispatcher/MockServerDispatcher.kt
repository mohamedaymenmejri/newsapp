package com.aymen.instantnews.dispatcher

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest

class MockServerDispatcher {

    //  valid response dispatcher
    class ResponseDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse {
            if (request.path.equals(
                    "/v2/top-headlines?category=general&country=fr",
                    true
                )
            ) return MockResponse().setResponseCode(200).setBody(
                "{\n" +
                        "    \"status\": \"ok\",\n" +
                        "    \"totalResults\": 34,\n" +
                        "    \"articles\": [\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"Le HuffPost\"\n" +
                        "            },\n" +
                        "            \"author\": \"Le HuffPost avec AFP\",\n" +
                        "            \"title\": \"Royaume-Uni : Archie, 12 ans et en état de mort cérébrale, est décédé - Le HuffPost\",\n" +
                        "            \"description\": \"Archie Battersbee était au cœur d’une bataille judiciaire entre ses parents et la justice britannique qui voulait mettre fin à ses soins.\",\n" +
                        "            \"url\": \"https://www.huffingtonpost.fr/international/article/royaume-uni-archie-12-ans-et-en-etat-de-mort-cerebrale-est-decede_206308.html\",\n" +
                        "            \"urlToImage\": \"https://huffpost-focus.sirius.press/2022/08/06/c59b900_1659792582185-screenshot-2022-08-06-15-29-24.png\",\n" +
                        "            \"publishedAt\": \"2022-08-06T13:42:53Z\",\n" +
                        "            \"content\": \"ROYAUME-UNI - « Il sest battu jusquà la toute fin ». Archie Battersbee, le jeune Britannique de 12 ans en état de mort cérébrale depuis quatre mois, est mort ce samedi 6 août après larrêt des soins q… [+4188 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": \"lequipe\",\n" +
                        "                \"name\": \"L'equipe\"\n" +
                        "            },\n" +
                        "            \"author\": \"Rédaction\",\n" +
                        "            \"title\": \"Lourde chute d'Aleix Espargaro lors des essais libres du Grand Prix de Grande-Bretagne - L'Équipe\",\n" +
                        "            \"description\": \"L'Espagnol Aleix Espargaro (Aprilia) a été victime d'une lourde chute, samedi lors de la quatrième et dernière séance d'essais libres du Grand Prix de Grande-Bretagne. Mais il pourra prendre part aux qualifications.\",\n" +
                        "            \"url\": \"https://www.lequipe.fr/Moto/Actualites/Lourde-chute-d-aleix-espargaro-lors-des-essais-libres-du-grand-prix-de-grande-bretagne/1346916\",\n" +
                        "            \"urlToImage\": \"https://medias.lequipe.fr/img-photo-jpg/-s-mantey-l-equipe/1500000001671891/0:0,1332:1332-640-640-75/ebe28.jpg\",\n" +
                        "            \"publishedAt\": \"2022-08-06T13:31:20Z\",\n" +
                        "            \"content\": \"Aleix Espargaro (Aprilia), deuxième du classement du Championnat du monde de MotoGP, derrière Fabio Quartararo, a été victime d'une lourde chute, samedi lors de la quatrième et dernière séance d'essa… [+73 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": \"google-news\",\n" +
                        "                \"name\": \"Google News\"\n" +
                        "            },\n" +
                        "            \"author\": null,\n" +
                        "            \"title\": \"Météo. Quatre signes qui prouvent que l’été 2022 n’est pas « un été comme ceux qu’on avait avant » - Ouest-France\",\n" +
                        "            \"description\": null,\n" +
                        "            \"url\": \"https://news.google.com/__i/rss/rd/articles/CBMiqQFodHRwczovL3d3dy5vdWVzdC1mcmFuY2UuZnIvbWV0ZW8vY2FuaWN1bGUvbWV0ZW8tcXVhdHJlLXNpZ25lcy1xdWktcHJvdXZlbnQtcXVlLW5vbi1jZS1uLWVzdC1wYXMtdW4tZXRlLWNvbW1lLWNldXgtcXUtb24tYXZhaXQtYXZhbnQtNmM2OWZmZjQtMTU2OC0xMWVkLWI5N2MtZWY4YmFmZjMwN2Vl0gEA?oc=5\",\n" +
                        "            \"urlToImage\": null,\n" +
                        "            \"publishedAt\": \"2022-08-06T12:36:42Z\",\n" +
                        "            \"content\": null\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": \"google-news\",\n" +
                        "                \"name\": \"Google News\"\n" +
                        "            },\n" +
                        "            \"author\": null,\n" +
                        "            \"title\": \"Limoges : quatre personnes, dont «un espoir du basket français», interpellées à la suite d'émeutes urbaines - Le Figaro\",\n" +
                        "            \"description\": null,\n" +
                        "            \"url\": \"https://news.google.com/__i/rss/rd/articles/CBMikwFodHRwczovL3d3dy5sZWZpZ2Fyby5mci9mYWl0cy1kaXZlcnMvbGltb2dlcy1xdWF0cmUtcGVyc29ubmVzLWRvbnQtdW4tZXNwb2lyLWR1LWJhc2tldC1mcmFuY2Fpcy1pbnRlcnBlbGxlZXMtYS1sYS1zdWl0ZS1kLWVtZXV0ZXMtdXJiYWluZXMtMjAyMjA4MDbSAZMBaHR0cHM6Ly9hbXAubGVmaWdhcm8uZnIvZmFpdHMtZGl2ZXJzL2xpbW9nZXMtcXVhdHJlLXBlcnNvbm5lcy1kb250LXVuLWVzcG9pci1kdS1iYXNrZXQtZnJhbmNhaXMtaW50ZXJwZWxsZWVzLWEtbGEtc3VpdGUtZC1lbWV1dGVzLXVyYmFpbmVzLTIwMjIwODA2?oc=5\",\n" +
                        "            \"urlToImage\": null,\n" +
                        "            \"publishedAt\": \"2022-08-06T11:08:42Z\",\n" +
                        "            \"content\": null\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": \"google-news\",\n" +
                        "                \"name\": \"Google News\"\n" +
                        "            },\n" +
                        "            \"author\": null,\n" +
                        "            \"title\": \"Elon Musk relance la possibilité de racheter Twitter - Le Figaro\",\n" +
                        "            \"description\": null,\n" +
                        "            \"url\": \"https://news.google.com/__i/rss/rd/articles/CBMiZ2h0dHBzOi8vd3d3LmxlZmlnYXJvLmZyL3NlY3RldXIvaGlnaC10ZWNoL2Vsb24tbXVzay1yZWxhbmNlLWxhLXBvc3NpYmlsaXRlLWRlLXJhY2hldGVyLXR3aXR0ZXItMjAyMjA4MDbSAWdodHRwczovL2FtcC5sZWZpZ2Fyby5mci9zZWN0ZXVyL2hpZ2gtdGVjaC9lbG9uLW11c2stcmVsYW5jZS1sYS1wb3NzaWJpbGl0ZS1kZS1yYWNoZXRlci10d2l0dGVyLTIwMjIwODA2?oc=5\",\n" +
                        "            \"urlToImage\": null,\n" +
                        "            \"publishedAt\": \"2022-08-06T10:55:15Z\",\n" +
                        "            \"content\": null\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"Francetvinfo.fr\"\n" +
                        "            },\n" +
                        "            \"author\": null,\n" +
                        "            \"title\": \"Loire-Atlantique : un pompier meurt lors d'une intervention - franceinfo\",\n" +
                        "            \"description\": \"Le pompier qui officiait à Saint-Lyphard, près de Guérande, est mort lors d'une intervention pour un feu dans des champs vendredi soir.\",\n" +
                        "            \"url\": \"https://www.francetvinfo.fr/faits-divers/loire-atlantique-un-pompier-meurt-lors-d-une-intervention_5296351.html\",\n" +
                        "            \"urlToImage\": \"https://www.francetvinfo.fr/pictures/bWLLTXP_CNRvG4ycaWKatxwozdw/1500x843/2022/08/06/phponXp9r.jpg\",\n" +
                        "            \"publishedAt\": \"2022-08-06T10:53:29Z\",\n" +
                        "            \"content\": \"Le pompier qui officiait à Saint-Lyphard, près de Guérande, est mort lors d'une intervention pour un feu dans des champs vendredi soir.Un pompier est mort vendredi 5 août lors d'une intervention pour… [+1442 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"BFMTV\"\n" +
                        "            },\n" +
                        "            \"author\": null,\n" +
                        "            \"title\": \"Départs en vacances: plus de 1000 kilomètres de bouchons enregistrés ce samedi à la mi-journée - BFMTV\",\n" +
                        "            \"description\": \"Le trafic était ralenti pour ce deuxième grand week-end de chassé-croisé de l'été, avec 1060 km de bouchons cumulés enregistrés par Bison Futé ce samedi.\",\n" +
                        "            \"url\": \"https://www.bfmtv.com/info-trafic/departs-en-vacances-plus-de-1000-kilometres-de-bouchons-enregistres-ce-samedi-a-la-mi-journee_AD-202208060114.html\",\n" +
                        "            \"urlToImage\": \"https://images.bfmtv.com/GjSv9tdplRg9eE5JTUIHOgCNWEU=/0x142:2048x1294/2048x0/images/Bouchons-1419475.jpg\",\n" +
                        "            \"publishedAt\": \"2022-08-06T10:23:00Z\",\n" +
                        "            \"content\": \"Le trafic était ralenti pour ce deuxième grand week-end de chassé-croisé de l'été, avec 1060 km de bouchons cumulés enregistrés par Bison Futé ce samedi.\\r\\nLa circulation était difficile ce samedi sur… [+1975 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"Paris Match\"\n" +
                        "            },\n" +
                        "            \"author\": null,\n" +
                        "            \"title\": \"Kim Kardashian célibataire, c'est fini avec Pete Davidson - Paris Match\",\n" +
                        "            \"description\": \"Et ce ne sont pas leurs 13 ans de différence d'âge qui sont en cause...\",\n" +
                        "            \"url\": \"https://www.parismatch.com/People/Kim-Kardashian-celibataire-c-est-fini-avec-Pete-Davidson-1820463\",\n" +
                        "            \"urlToImage\": \"https://resize-parismatch.lanmedia.fr/var/pm/public/media/image/2022/08/06/11/kim-kardashian-celibataire-c-est-fini-avec-pete-davidson.jpg?VersionId=bgoMDXz13..WfTAkoE1dh6p7rYoUUv1w\",\n" +
                        "            \"publishedAt\": \"2022-08-06T09:23:00Z\",\n" +
                        "            \"content\": \"Et ce ne sont pas leurs 13 ans de différence d'âge qui sont en cause...Après dix mois de romance, Kim Kardashian et Pete Davidson ont finalement rompu. Leur récente séparation a été rapportée par le … [+1400 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"BFMTV\"\n" +
                        "            },\n" +
                        "            \"author\": null,\n" +
                        "            \"title\": \"Le béluga dans la Seine continue de ne pas s'alimenter - BFMTV\",\n" +
                        "            \"description\": \"L'animal, qui vit habituellement dans les eaux froides, est le second béluga repéré en France. Il continue de faire l'objet d'une surveillance accrue des associations et des services de l'État.\",\n" +
                        "            \"url\": \"https://www.bfmtv.com/animaux/le-beluga-dans-la-seine-continue-de-ne-pas-s-alimenter_AD-202208060084.html\",\n" +
                        "            \"urlToImage\": \"https://images.bfmtv.com/0sDB7YbQyCZv30rvYx4BPR5kK1A=/0x40:768x472/768x0/images/Un-beluga-repere-dans-la-Seine-nage-pres-d-une-ecluse-a-Courcelles-sur-Seine-le-5-aout-2022-dans-l-Eure-1461398.jpg\",\n" +
                        "            \"publishedAt\": \"2022-08-06T09:13:55Z\",\n" +
                        "            \"content\": \"L'animal, qui vit habituellement dans les eaux froides, est le second béluga repéré en France. Il continue de faire l'objet d'une surveillance accrue des associations et des services de l'État.\\r\\nUn b… [+1281 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"Sud Ouest\"\n" +
                        "            },\n" +
                        "            \"author\": \"SudOuest.fr\",\n" +
                        "            \"title\": \"Météo : jusqu’à 40°C dans le Sud-Ouest... Et c’est reparti pour une nouvelle vague de chaleur la semaine prochaine - Sud Ouest\",\n" +
                        "            \"description\": \"Le mercure va de nouveau grimper au-delà des 35°C partout en Nouvelle-Aquitaine au milieu de la semaine du 8 au 14 août. Une quatrième vague de chaleur qui ne fera qu’empirer la sécheresse\",\n" +
                        "            \"url\": \"https://www.sudouest.fr/environnement/meteo/meteo-et-c-est-reparti-pour-une-nouvelle-vague-de-chaleur-la-semaine-prochaine-11875593.php\",\n" +
                        "            \"urlToImage\": \"https://media.sudouest.fr/11875593/1200x-1/sudouest-photo-1-24266638.jpg\",\n" +
                        "            \"publishedAt\": \"2022-08-06T09:01:23Z\",\n" +
                        "            \"content\": \"Après un week-end « de saison » sur le plan des températures (31°C à Bordeaux, 28°C à La Rochelle, 26°C à Biarritz), le mercure va sérieusement repartir à la hausse en raison de la présence dun puiss… [+2894 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"Francetvinfo.fr\"\n" +
                        "            },\n" +
                        "            \"author\": \"France 3 Bretagne\",\n" +
                        "            \"title\": \"DIRECT VIDÉO. Festival Interceltique de Lorient 2022 : Suivez la finale du Championnat National des bagadoù de 1re catégorie à 13h sur notre site internet - France 3 Régions\",\n" +
                        "            \"description\": \"Ce samedi 6 août a lieu la finale du Championnat National des bagadoù au Festival Interceltique de Lorient. C'est un événement attendu dans le monde de la culture bretonne qui n'a pas eu lieu pendant deux ans. Le Stade du...\",\n" +
                        "            \"url\": \"https://france3-regions.francetvinfo.fr/bretagne/morbihan/lorient/direct-video-festival-interceltique-de-lorient-2022-suivez-la-finale-du-championnat-national-des-bagadou-de-1re-categorie-a-13h-sur-france-3-bretagne-2592096.html\",\n" +
                        "            \"urlToImage\": \"https://france3-regions.francetvinfo.fr/image/s2iR79OZ6uXfUlVQxIISlxB120I/930x620/regions/2022/08/05/62ecccb8f181b_61126dfa0000000000000000-big.jpg\",\n" +
                        "            \"publishedAt\": \"2022-08-06T09:00:42Z\",\n" +
                        "            \"content\": \"Ce samedi 6 août a lieu la finale du Championnat National des bagadoù au Festival Interceltique de Lorient. C'est un événement attendu dans le monde de la culture bretonne qui n'a pas eu lieu pendant… [+1429 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"20 Minutes\"\n" +
                        "            },\n" +
                        "            \"author\": null,\n" +
                        "            \"title\": \"Guerre en Ukraine EN DIRECT : A Hiroshima, Antonio Guterres alerte sur le risque d'une attaque nucléaire... - 20 Minutes\",\n" +
                        "            \"description\": \"Suivez avec nous toutes les informations sur le conflit en ce samedi 6 août\",\n" +
                        "            \"url\": \"https://www.20minutes.fr/monde/3334551-20220806-guerre-ukraine-direct-hiroshima-antonio-guterres-alerte-risque-attaque-nucleaire\",\n" +
                        "            \"urlToImage\": \"https://img.20mn.fr/mLVSRyEIQA-u6yuy0FHn7yk/1200x768_antonio-guterres-risque-arme-nucleaire-employee-reel\",\n" +
                        "            \"publishedAt\": \"2022-08-06T08:34:53Z\",\n" +
                        "            \"content\": \"9h14 : A Hiroshima, le chef de l’ONU dit que l’humanité « joue avec un pistolet chargé »L’humanité « joue avec un pistolet chargé » dans le contexte des crises actuelles à connotation nucléaire, a av… [+975 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": \"google-news\",\n" +
                        "                \"name\": \"Google News\"\n" +
                        "            },\n" +
                        "            \"author\": null,\n" +
                        "            \"title\": \"La responsable d'Amnesty en Ukraine démissionne, accusant son organisation d'avoir servi «la propagande russe» - Le Figaro\",\n" +
                        "            \"description\": null,\n" +
                        "            \"url\": \"https://news.google.com/__i/rss/rd/articles/CBMimgFodHRwczovL3d3dy5sZWZpZ2Fyby5mci9pbnRlcm5hdGlvbmFsL2xhLXJlc3BvbnNhYmxlLWQtYW1uZXN0eS1lbi11a3JhaW5lLWRlbWlzc2lvbm5lLWFjY3VzYW50LXNvbi1vcmdhbmlzYXRpb24tZC1hdm9pci1zZXJ2aS1sYS1wcm9wYWdhbmRlLXJ1c3NlLTIwMjIwODA20gGaAWh0dHBzOi8vYW1wLmxlZmlnYXJvLmZyL2ludGVybmF0aW9uYWwvbGEtcmVzcG9uc2FibGUtZC1hbW5lc3R5LWVuLXVrcmFpbmUtZGVtaXNzaW9ubmUtYWNjdXNhbnQtc29uLW9yZ2FuaXNhdGlvbi1kLWF2b2lyLXNlcnZpLWxhLXByb3BhZ2FuZGUtcnVzc2UtMjAyMjA4MDY?oc=5\",\n" +
                        "            \"urlToImage\": null,\n" +
                        "            \"publishedAt\": \"2022-08-06T08:19:29Z\",\n" +
                        "            \"content\": null\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": \"le-monde\",\n" +
                        "                \"name\": \"Le Monde\"\n" +
                        "            },\n" +
                        "            \"author\": \"Simon Leplâtre\",\n" +
                        "            \"title\": \"Pékin se retire des négociations avec Washington sur le climat - Le Monde\",\n" +
                        "            \"description\": \"La Chine multiplie les mesures de représailles après la visite de la responsable américaine Nancy Pelosi sur l’île de Taïwan.\",\n" +
                        "            \"url\": \"https://www.lemonde.fr/international/article/2022/08/06/pekin-se-retire-des-negociations-avec-washington-sur-le-climat_6137352_3210.html\",\n" +
                        "            \"urlToImage\": \"https://img.lemde.fr/2022/08/05/0/6/6036/4024/1440/960/60/0/cc16158_5874653-01-06.jpg\",\n" +
                        "            \"publishedAt\": \"2022-08-06T08:18:46Z\",\n" +
                        "            \"content\": \"Un navire militaire chinois navigue au large de lîle de Pingtan, lun des points de la Chine continentale les plus proches de Taïwan, le 5 août 2022. HECTOR RETAMAL / AFP\\r\\nQuatre jours après la visite… [+3076 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"Onze Mondial\"\n" +
                        "            },\n" +
                        "            \"author\": \"Nathan Bricout\",\n" +
                        "            \"title\": \"Clermont - PSG : Galtier va reconduire le même onze que lors du Trophée des Champions ! - Onze Mondial\",\n" +
                        "            \"description\": \"Christophe Galtier, l'entraîneur du PSG, devrait reconduire le même onze de départ que lors du Trophée des Champions ce soir contre Clermont.\",\n" +
                        "            \"url\": \"https://www.onzemondial.com/ligue-1/clermont-psg-galtier-va-reconduire-le-meme-onze-que-lors-du-trophee-des-champions-790460\",\n" +
                        "            \"urlToImage\": \"https://static.onzemondial.com/8/2022/08/photo_article/790460/312738/1200-L-clermont-psg-galtier-va-reconduire-le-mme-onze-que-lors-du-trophe-des-champions.jpg\",\n" +
                        "            \"publishedAt\": \"2022-08-06T08:02:04Z\",\n" +
                        "            \"content\": \"On ne change pas une équipe qui gagne ! Large vainqueur de Nantes dans le Trophée des Champions dimanche dernier, Christophe Galtier devrait reconduire le même onze de départ annonce RMC Sport. Décou… [+163 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"Olympique et Lyonnais\"\n" +
                        "            },\n" +
                        "            \"author\": \"David Hernandez\",\n" +
                        "            \"title\": \"OL - Ajaccio (2-1) : Anthony Lopes s’est \\\"excusé auprès de tout le monde\\\" - Olympique et Lyonnais\",\n" +
                        "            \"description\": \"Exclu après 25 minutes de jeu contre Ajaccio, Anthony Lopes s’en est voulu et gâche du même coup son début de saison.\",\n" +
                        "            \"url\": \"https://www.olympique-et-lyonnais.com/ol-ajaccio-2-1-anthony-lopes-sest-excuse-aupres-de-tout-le-monde,264790.html\",\n" +
                        "            \"urlToImage\": \"https://www.olympique-et-lyonnais.com/wp-content/uploads/2019/04/Lopesrennes.jpg\",\n" +
                        "            \"publishedAt\": \"2022-08-06T07:20:14Z\",\n" +
                        "            \"content\": \"Dans la mesure où non seulement il doit énormément s'en vouloir, dans la mesure où il a été et sera encore sanctionné, et surtout dans la mesure où l'OL a quand même gagné, je relativise ce qu'il a f… [+1647 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"20 Minutes\"\n" +
                        "            },\n" +
                        "            \"author\": null,\n" +
                        "            \"title\": \"RC Strasbourg - AS Monaco EN DIRECT : Les Monégasques reprennent dans la fournaise de La Meinau... Suivez la… - 20 Minutes\",\n" +
                        "            \"description\": \"Troisième du dernier championnat et engagé dans une double confrontation périlleuse en Ligue des champions contre Eindhoven, Monaco lance son championnat avec déjà une belle affiche à Strasbourg\",\n" +
                        "            \"url\": \"https://www.20minutes.fr/sport/3333011-20220806-rc-strasbourg-monaco-direct-monegasques-reprennent-fournaise-meinau-suivez-ligue-1\",\n" +
                        "            \"urlToImage\": \"https://img.20mn.fr/RVS5_ixeR3-kGjixg5spgQ/1200x768_takumi-minamino-nouvelle-recrue-de-monaco-en-match-amical-le-27-juillet-photo-by-james-marsh\",\n" +
                        "            \"publishedAt\": \"2022-08-06T07:05:04Z\",\n" +
                        "            \"content\": \"L‘accès à ce contenu a été bloqué afin de respecter votre choix de consentement\\r\\nEn cliquant sur « J‘ACCEPTE », vous acceptez le dépôt de cookies par des services externes et aurez ainsi accès aux co… [+275 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"CNEWS.fr\"\n" +
                        "            },\n" +
                        "            \"author\": \"CNEWS\",\n" +
                        "            \"title\": \"Psoriasis : ces 4 aliments à éviter - CNEWS\",\n" +
                        "            \"description\": \"Maladie inflammatoire chronique, le psoriasis se manifeste par des plaques cutanées recouvertes de squames, ces fines lamelles de peau blanchâtres. Et certains aliments ont tendance à aggraver cette affection.\",\n" +
                        "            \"url\": \"https://www.cnews.fr/sante/2022-08-06/psoriasis-ces-4-aliments-eviter-1249928\",\n" +
                        "            \"urlToImage\": \"https://static.cnews.fr/sites/default/files/psoriasis-ga616c9949_1920-taille1200_62e94be5377ec.jpg\",\n" +
                        "            \"publishedAt\": \"2022-08-06T06:19:04Z\",\n" +
                        "            \"content\": \"Publié le\\r\\n06/08/2022 à 08:05 -\\r\\nMis à jour le\\r\\n06/08/2022 à 08:05\\r\\nMaladie inflammatoire chronique, le psoriasis se manifeste par des plaques cutanées recouvertes de squames, ces fines lamelles de p… [+876 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"Francetvinfo.fr\"\n" +
                        "            },\n" +
                        "            \"author\": null,\n" +
                        "            \"title\": \"Frappes sur Gaza : \\\"L'armée israélienne se prépare à une escalade\\\", analyse un spécialiste - franceinfo\",\n" +
                        "            \"description\": \"Depuis vendredi, des échanges de tirs ont lieu entre Israël et Gaza. C'est l'arrestation, en début de semaine, d'un chef du groupe Jihad islamique en Cisjordanie occupée qui a mené à cette nouvelle confrontation armée.\",\n" +
                        "            \"url\": \"https://www.francetvinfo.fr/monde/proche-orient/israel-palestine/frappes-sur-gaza-l-armee-israelienne-se-prepare-a-une-escalade-analyse-un-specialiste_5296237.html\",\n" +
                        "            \"urlToImage\": \"https://www.francetvinfo.fr/pictures/V_yNMxkb_4ougBBRA6MItt8UaDY/1500x843/2022/08/06/phpb9wUc9.jpg\",\n" +
                        "            \"publishedAt\": \"2022-08-06T06:12:34Z\",\n" +
                        "            \"content\": \"Depuis vendredi, des échanges de tirs ont lieu entre Israël et Gaza. C'est l'arrestation, en début de semaine, d'un chef du groupe Jihad islamique en Cisjordanie occupée qui a mené à cette nouvelle c… [+3652 chars]\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"source\": {\n" +
                        "                \"id\": null,\n" +
                        "                \"name\": \"L'Indépendant\"\n" +
                        "            },\n" +
                        "            \"author\": \"L'Indépendant\",\n" +
                        "            \"title\": \"Covid long : difficultés respiratoires, douleurs abdominales, fatigue... un patient sur huit garderait au moin - L'Indépendant\",\n" +
                        "            \"description\": \"Parmi les personnes atteintes de Covid 19, une sur huit garde à long terme l'un des symptômes caractéristiques du Covid long, montre une étude de grande ampleur publiée vendredi.\",\n" +
                        "            \"url\": \"https://www.lindependant.fr/2022/08/06/covid-long-difficultes-respiratoires-douleurs-abdominales-fatigue-un-patient-sur-huit-garderait-au-moins-un-symptome-durable-10475688.php\",\n" +
                        "            \"urlToImage\": \"https://images.lindependant.fr/api/v1/images/view/62ee04b3e722036aac2189d4/large/image.jpg?v=1\",\n" +
                        "            \"publishedAt\": \"2022-08-06T06:06:00Z\",\n" +
                        "            \"content\": \"Parmi les personnes atteintes de Covid 19, une sur huit garde à long terme l'un des symptômes caractéristiques du Covid long, montre une étude de grande ampleur publiée vendredi.\\r\\n Ces symptômes comp… [+2282 chars]\"\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}"
            )
            return MockResponse().setResponseCode(400)
        }
    }

    //  error dispatcher
    class ErrorDispatcher : Dispatcher() {
        override fun dispatch(request: RecordedRequest): MockResponse =
            MockResponse().setResponseCode(400)
    }
}
Implementatie
=============

Vertaalspecificaties
--------------------

Een adres bestaat uit een samenstelling van attribuutwaarden van 3 IMBAG
objecttypen: Nummeraanduidingreeks, Openbareruimte en Woonplaats.

![](media/23df9f803f23bc2b9d43cde4f3c49112.png)

De relatie tussen de attributen van IMBAG en het Productmodel Adres staat
hieronder gespecificieerd.

### Objecttype Adres

Voor objecttype Adres wordt een attribuutwaarde in gevuld met de waarde welke
correspondeert met een attribuutwaarde van een objecttype in de BAG conform
onderstaande tabel.

| **Productmodel Adres** |                      |                      | **IMBAG**                                                                    |                            |                 |   |   |   |
|------------------------|----------------------|----------------------|------------------------------------------------------------------------------|----------------------------|-----------------|---|---|---|
| **objecttype**         | **attribuut**        | **datatype**         | **objecttype**                                                               | **attribuut**              | **datatype**    |   |   |   |
| Adres                  | identificatie        | CharacterString {id} | Nummeraanduiding                                                             | identificatie              | Objectnummering |   |   |   |
|                        | omschrijving         | CharacterString      |                                                                              |                            |                 |   |   |   |
|                        | huisnummer           | Integer              |                                                                              | huisnummer                 | Integer         |   |   |   |
|                        | huisletter           | CharacterString      |                                                                              | huisletter                 | AN              |   |   |   |
|                        | huisnummertoevoeging | CharacterString      |                                                                              | huisnummertoevoeging       | AN              |   |   |   |
|                        | postcode             | CharacterString      |                                                                              | postcode                   | AN              |   |   |   |
|                        |                      |                      |                                                                              | gerelateerdeOpenbareRuimte | Objectnummering |   |   |   |
|                        | straatnaam           | CharacterString      | Openbareruimte                                                               | naam                       | AN              |   |   |   |
|                        |                      |                      |                                                                              | gerelateerdeWoonplaats     | Objectnummering |   |   |   |
|                        | woonplaats           | CharacterString      | Woonplaats                                                                   | naam                       | AN              |   |   |   |
|                        | *isHoofdadres*       | *Boolean*            | *«Nummeraanduiding:identificatie» == «AdresseerbaarObject:gerelateerdAdres»* | *relatie*                  |                 |   |   |   |

Adres:nummeraanduiding is samenstelling van verschillende attributen:

-   naam van BAG:OpenbareRuimte:naam,

-   gevolgd door een spatie, gevolgd door huisnummer van BAG:Nummeraanduiding,

-   evt. gevolgd door spatie en huisnummerletter van BAG:Nummeraanduiding,

-   evt. gevolgd door koppelteken (-) en huisnummertoevoeging van
    BAG:Nummeraanduiding, gevolgd door komma en spatie,

-   gevolgd door postcode van BAG:Nummeraanduiding,

-   gevolgd door twee spatie,

-   gevolgd door naam van BAG:Woonplaats

Bijvoorbeeld

“Barchman Wuytierslaan 10, 3818LH Amersfoort”

>   “Korenaarstraat 33 A-1, Nieuw-Vennep”

Reguliere expressie:

\^(«BAG:OpenbareRuimte:naam»)(\\s)(«BAG:Nummeraanduiding:huisnummer»)(\\s)(«BAG:Nummeraanduiding:huisletter»)(\\-)(«BAG:Nummeraanduiding:huisnummertoevoeging»)(,\\s)(«BAG:Nummeraanduiding:postcode»)(\\s\\s)(BAG:Woonplaats:naam)

### Objecttype Orkestratiegegeven

Voor objecttype Orkestratiegegeven wordt een kenmerk gevuld met de waarde welke
correspondeert met een attribuutwaarde van objecttype Adres conform onderstaande
tabel.

| **Productmodel Adres** |                      | **Productmodel Adres** |                |
|------------------------|----------------------|------------------------|----------------|
| **objecttype**         | **kenmerk**          | **objecttype**         | **attribuut**  |
| Orkestratiegegeven     | identificatie        | Adres                  | identificatie  |
|                        | omschrijving         |                        | omschrijving   |
|                        | huisnummer           |                        | huisnummer     |
|                        | huisletter           |                        | huisletter     |
|                        | huisnummertoevoeging | huisnummertoevoeging   |                |
|                        | postcode             |                        | postcode       |
|                        |                      |                        |                |
|                        | straatnaam           |                        | straatnaam     |
|                        |                      |                        |                |
|                        | woonplaats           |                        | woonplaats     |
|                        | *isHoofdadres*       |                        | *isHoofdadres* |
|                        |                      |                        |                |
|                        | **Bronregistratie**  | naam                   | «BAG»          |

### Objecttype Brongegeven

Voor objecttype Brongegeven wordt een kenmerk gevuld met de waarde welke
correspondeert met een attribuutwaarde van een objecttype uit de BAG conform
onderstaande tabel.

| **Productmodel Adres** |                            | **IMBAG**                                                                    |               |
|------------------------|----------------------------|------------------------------------------------------------------------------|---------------|
| **objecttype**         | **kenmerk**                | **objecttype**                                                               | **attribuut** |
| Brongegeven            | identificatie              | Nummeraanduiding                                                             | identificatie |
|                        |                            |                                                                              |               |
|                        | huisnummer                 |                                                                              | huisnummer    |
|                        | huisletter                 |                                                                              | huisletter    |
|                        | huisnummertoevoeging       | huisnummertoevoeging                                                         |               |
|                        | postcode                   |                                                                              | postcode      |
|                        | gerelateerdeOpenbareRuimte | gerelateerdeOpenbareRuimte                                                   |               |
|                        | naam                       | Openbareruimte                                                               | naam          |
|                        | gerelateerdeWoonplaats     | gerelateerdeWoonplaats                                                       |               |
|                        | naam                       | Woonplaats                                                                   | naam          |
|                        | *gerelateerdAdres*         | *«Nummeraanduiding:identificatie» == «AdresseerbaarObject:gerelateerdAdres»* |               |

### Relatie Orkestratiegegeven is afgeleid uit Brongegeven

Voor objecttype Orkestratiegegeven wordt de relatie ‘is afgeleid van’ met één of
meer brongegevens gelegd conform onderstaande tabel.

| **Productmodel Adres** |                      | **Productmodel Adres** |                            |
|------------------------|----------------------|------------------------|----------------------------|
| **objecttype**         | **kenmerk**          | **objecttype**         | **kenmerk**                |
| Orkestratiegegeven     | identificatie        | Brongegeven            | identificatie              |
|                        | omschrijving         |                        |                            |
|                        | huisnummer           |                        | huisnummer                 |
|                        | huisletter           |                        | huisletter                 |
|                        | huisnummertoevoeging |                        | huisnummertoevoeging       |
|                        | postcode             |                        | postcode                   |
|                        |                      |                        | gerelateerdeOpenbareRuimte |
|                        | straatnaam           |                        | naam                       |
|                        |                      |                        | gerelateerdeWoonplaats     |
|                        | woonplaats           |                        | naam                       |
|                        | *isHoofdadres*       |                        | *gerelateerdAdres*         |

JSON Voorbeeld
--------------

### Object adres zonder registraties

### `    {`

### `      "adres": {`

### `        "identificatie": "0307200000456181",`

### `        "omschrijving": "Barchman Wuytierslaan 10, 3818LH Amersfoort",`

### `        "straat": "Barchman Wuytierslaan",`

### `        "huisnummer": "10",`

### `        "huisletter": null,`

### `        "huisnummertoevoeging": null,`

### `        "postcode": "3818LH",`

### `        "plaats": "Amersfoort",`

### `    }`

### Registratiegegevens voor attribuut identificatie van Adres

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

{"registratiegegevens": {

"orkestratiegegeven.1": {

"kenmerk": "identificatie",

"waarde": "03070201234567890123456",

"brongegeven" : {

"kenmerk": "identificatie",

"waarde”: "03070201234567890123456",

"bronregistratie”: "BAG",

"bronobject" : {

"type": "Nummeraanduiding",

"identificatie": "03070201234567890123456",

},

},

},

}},  
}

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

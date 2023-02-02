Use Case: Opvragen adres
------------------------

Wie een samengesteld adres van een adresseerbaar object (verblijfsobject, stand-
of ligplaats) wil opvragen uit de BAG, heeft daar vier objecttypen voor nodig:

1.  het object Verblijfsobject, Ligplaats of Standplaats voor het ID en
    eventueel de locatie,

2.  het gerelateerde object Nummeraanduiding voor de postcode en huisnummer
    (eventueel met toevoegingen),

3.  het object gerelateerde object OpenbareRuimte voor de straatnaam en

4.  het gerelateerde object Woonplaats voor de woonplaats.

![](media/832535c726d498e58b84ce15bd0602d8.png)

Via de oranje route in de afbeelding kom je van adresseer object in de BAG naar
uiteindelijk het laatste gegeven van een adres in de BAG, de woonplaats.

Voor deze route maken we een compact samenhangend semantisch model Adres.
Vervolgens specificeren we de vertaling van de benodigde objectgegevens in de
BAG naar het productmodel Adres. De vertaalspecificatie is de basis voor de
orkestratie door de registratie. De aansluiting tussen registratie en
orkestratielaag en de werking van de orkestratie zelf, testen we met
demo-software.

### User story

We hanteren de volgende user story:

*Als* gebruiker

*wil ik* een actueel en compleet adres opvragen van een individueel object,

*zodat ik* dit niet zelf hoef samenstellen uit meerdere objecten in de BAG
(Nummeraanduiding, OpenbareRuimte en Woonplaats).

### Uitgangspunten

Voor deze use case hanteren we de volgende uitgangspunten:

-   Een gebruiker kan alleen actuele adressen opvragen. Een adres is inclusief
    nevenadressen.

-   We maken onderscheid tussen een hoofdadres en nevenadres bij het
    beantwoorden van vraag naar adres van gebruiker.

-   Een adres wordt geselecteerd op basis van het oorspronkelijke identificatie
    in de BAG (filter op objectidentificatie van Numeraanduidingreeks). Een
    identificatie van een Nummeraanduidingreeks is opgenomen in de relatie
    ‘heeft als hoofdadres’ of ‘heeft als nevenadres’ van een Adressbaar Object
    in de BAG.

-   Een adres kan worden geselecteerd op basis van een specifiek kenmerk (filter
    op attribuut), bijvoorbeeld een selectie van adressen op basis van
    straatnaam, postcode of woonplaats.

### Buiten scope

De volgende onderwerpen plaatsen we (voor nu) buiten scope:

-   Niet-actuele adressen, ofwel historie

-   Het filteren van adressen op basis van een pand identificatie (‘Geef mij
    alle adressen in dit specifieke pand’)

-   Het filteren van adressen op basis van een geometrie (bounding box).

### Ontwerpprincipes

Voor het productmodel Adres hanteren we de volgende ontwerpprincipes. De
ontwerpprincipes bepalen de modelleerkeuzes in het model.

-   Een adres wordt als Onderwerp gezien in dit projectmodel.

-   Elke onderwerp wordt samengesteld uit één of meer orkestratiegegevens, of
    anders gezegd: een orkestratiegegeven maakt deel uit van een onderwerp.

-   De herkomst van een georkestreerd gegeven moet expliciet per gegeven worden
    vastgelegd. Een orkestratiegegeven is afgeleid van één of meer brongegevens.

-   Een brongegeven hoort bij een bronobject en heeft als herkomst een
    bronregistratie.

-   Een adres is een hoofdadres of nevenadres, en wordt opgenomen met een
    eigenschap isHoofdadres ja/nee als eigenschap van Adres.

-   Geometrie maakt geen onderdeel uit van het Adres. Adresseerbare objecten en
    Pand hebben wel een geometrie, maar vormen geen onderdeel van het
    productmodel Adres.

-   Een specificieke datatype van het brongegeven mag worden geconverteerd naar
    een algemene type (bijvoorbeeld AN in de BAG naar CharacterString in het
    productmodel Adres). Validatie is niet van toepassing, dus inperking van
    bijvoorbeeld een CharacterString is niet nodig.

-   De datatypen van attribuut waarde van Orkestratiegegeven en Brongegeven zijn
    nu ten behoeve van de leesbaarheid en eenvoud van het projectmodel Adres als
    keuze opgenomen.

>   N.B. Bij koppeling met andere bronregistraties moet deze Keuze-klasse
>   uitgebreid worden. Nader te bepalen in hoeverre dit werkbaar is, ook ten
>   opzichte van datatype-objecten als subtype van Orkestratiegegeven en
>   Brongegeven (zie Generieke Modelleer Patronen)

JSON voorbeeld
--------------

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
{
  "adres": {
    "identificatie": "0307200000456181",
    "omschrijving": "Barchman Wuytierslaan 10, 3818LH Amersfoort",
    "straat": "Barchman Wuytierslaan",
    "huisnummer": "10",
    "huisletter": null,
    "huisnummertoevoeging": null,
    "postcode": "3818LH",
    "plaats": "Amersfoort",
    "_metadata": {
      "herkomst": {
        "gegeven.1": {
          "naam": "identificatie",
          "bron": {
            "registratie": "BAG",
            "objecttype": "Nummeraanduiding",
            "object identificatie": {
              "lokaalid": "03070201234567890123456",
              "versie": "1",
              "tijdstipregistratie": "21-01-2010"
            },
            "attribuut": "identificatie"
          }
        },
        "gegeven.2": {
          "naam": "omschrijving",
          "bron.1": {
            "registratie": "BAG",
            "objecttype": "Nummeraanduiding",
            "object identificatie": {
              "lokaalid": "0307200000456181",
              "versie": "1",
              "tijdstipregistratie": "21-01-2010"
            },
            "attribuut.1": "huisnummer",
            "attribuut.2": "huisletter",
            "attribuut.3": "huisnummertoevoeging",
            "attribuut.4": "postcode"
          },
          "bron.2": {
            "registratie": "BAG",
            "objecttype": "OpenbareRuimte",
            "object identificatie": {
              "lokaalid": "0307200000456181",
              "versie": "1",
              "tijdstipregistratie": "21-01-2010"
            },
            "attribuut": "naam"
          }
        },
        "gegeven.3": {
          "naam": "straat",
          "bron": {
            "registratie": "BAG",
            "objecttype": "OpenbareRuimte",
            "object identificatie": {
              "lokaalid": "0307300000306765",
              "versie": "1",
              "tijdstipregistratie": "21-01-2010"
            },
            "attribuut": "naam"
          }
        },
        "gegeven.4": {
          "naam": "huisnummer",
          "bron": {
            "registratie": "BAG",
            "objecttype": "Nummeraanduiding",
            "object identificatie": {
              "lokaalid": "0307200000456181",
              "versie": "1",
              "tijdstipregistratie": "21-01-2010"
            },
            "attribuut": "huisnummer"
          }
        },
        "gegeven.5": {
          "naam": "huisletter",
          "bron": {
            "registratie": "BAG",
            "objecttype": "Nummeraanduiding",
            "object identificatie": {
              "lokaalid": "0307200000456181",
              "versie": "1",
              "tijdstipregistratie": "21-01-2010"
            },
            "attribuut": "huisletter"
          }
        },
        "gegeven.6": {
          "naam": "huisnummertoevoeging",
          "bron": {
            "registratie": "BAG",
            "objecttype": "Nummeraanduiding",
            "object identificatie": {
              "lokaalid": "0307200000456181",
              "versie": "1",
              "tijdstipregistratie": "21-01-2010"
            },
            "attribuut": "huisnummertoevoeging"
          }
        },
        "gegeven.7": {
          "naam": "postcode",
          "bron": {
            "registratie": "BAG",
            "objecttype": "Nummeraanduiding",
            "object identificatie": {
              "lokaalid": "0307200000456181",
              "versie": "1",
              "tijdstipregistratie": "21-01-2010"
            },
            "attribuut": "postcode"
          }
        },
        "gegeven.8": {
          "naam": "plaats",
          "bron": {
            "registratie": "BAG",
            "objecttype": "Woonplaats",
            "object identificatie": {
              "lokaalid": "1664",
              "versie": "4",
              "tijdstipregistratie": "24-10-2019"
            },
            "attribuut": "postcode"
          }
        },
        "gegeven.9": {
          "naam": "isHoofdadres",
          "bron": {
            "registratie": "BAG",
            "objecttype": "Verblijfsobject",
            "object identificatie": {
              "lokaalid": "0307010000456182",
              "versie": "3",
              "tijdstipregistratie": "12-10-2015"
            },
            "relatie.1": "hoofdadres",
            "relatie.2": "nevenadres"
          }
        }
      }
    }
  }
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Vertaalspecificaties
====================

UC1 Adres
---------

Een adres bestaat uit een samenstelling van attribuutwaarden van 3 IMBAG
objecttypen: Nummeraanduidingreeks, Openbareruimte en Woonplaats.

![](media/23df9f803f23bc2b9d43cde4f3c49112.png)

De relatie tussen de attributen van IMBAG en het Productmodel Adres staat
hieronder gespecificieerd.

| IMBAG                 |                              | PM Adres |                      |
|-----------------------|------------------------------|----------|----------------------|
| Nummeraanduidingreeks | identificatie                | Adres    | identificatie        |
|                       | huisnummer                   |          | huisnummer           |
|                       | huisletter                   |          | huisletter           |
|                       | huisnummertoevoeging         |          | huisnummertoevoeging |
|                       | postcode                     |          | postcode             |
|                       | *gerelateerdeOpenbareRuimte* |          |                      |
| Openbareruimte        | naam                         |          | straatnaam           |
|                       | *gerelateerdeWoonplaats*     |          |                      |
| Woonplaats            | naam                         |          | woonplaats           |

Adres:nummeraanduiding is samenstelling van verschillende attributen:

-   naam van BAG:OpenbareRuimte:naam,

-   gevolgd door een spatie, gevolgd door huisnummer van BAG:Nummeraanduiding,

-   evt. gevolgd door spatie en huisnummertoevoeging van BAG:Nummeraanduiding,

-   evt. gevolgd door koppelteken (-) en huisnummertoevoeging van
    BAG:Nummeraanduiding, gevolgd door komma en spatie,

-   gevolgd door postcode van BAG:Nummeraanduiding,

-   gevolgd door twee spatie,

-   gevolgd door naam van BAG:Woonplaats

Bijvoorbeeld

“Barchman Wuytierslaan 10, 3818LH Amersfoort”

>   “Korenaarstraat 33 A-1, Nieuw-Vennep”

Reguliere expressie:

\^(«BAG:OpenbareRuimte:naam»)(\\s)(«BAG:Nummeraanduiding:huisnummer»)(«BAG:Nummeraanduiding:huisletter»)(\\-)(«BAG:Nummeraanduiding:huisnummertoevoeging»)(,\\s)(«BAG:Nummeraanduiding:postcode»)(\\s\\s)(BAG:Woonplaats:naam)

# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC4](#uc4): Przekazanie produktu kupującemu

[Kupujący](#ac2)
* [UC2](#uc2): Zaoferowanie wyższej kwoty za produkt
* [UC3](#uc3): Przekazanie należnosći sprzedającemu

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Zaoferowanie wyższej kwoty za produkt

**Aktorzy:** [Kupujący](#ac2)]

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu chęć zaoferowania wyższej kwoty za produkt.
2. System prosi o podanie nowej kwoty za produkt.
3. [Kupujący] (#ac2) podaje nową kwotę za produkt.
4. System weryfikuje poprawność danych.
5. System informuje o wystawieniu pomyślnej oferty za produkt.

**Scenariusze alternatywne:** 

1.A. Podano niepoprawną cenę.
* 4.A.1. System informuje o błędnie podanej cenie.
* 4.A.2. Przejdź do kroku 2.

### UC3: Przekazanie należnosći sprzedającemu

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu chęć przekazania należności kupującemu.
2. System przekierowuje [kupującego do zewnętrznej strony obsługującej opłaty.
3. [Kupujący](#ac2) dokonuje płatności za produkt.
4. System oczekuje na potwierdzenie przekazania należności sprzedającemu.
5. System informuje o poprawnym wykonaniu transakcji.
6. System zmiania status na "oplacone".

**Scenariusze alternatywne:** 

1.A. Podano niepoprawną cenę.
* 4.A.1. System informuje o błędnie dokonanej platności.
* 4.A.2. Przejdź do kroku 2.

### UC4: Przekazanie produktu kupującemu

**Aktorzy:** [Kupujący](#ac2), [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć poznania danych zwycięzcy aukcji.
2. System informuje Sprzedającego o danych zwycięzcy aukcji.
3. [Sprzedający] (#ac1) wysyła produkt Kupującemu
4. [Sprzedający] (#ac1) przekazuje do systemu informację o wysłaniu produktu
5. System zmienia status zamówienia na "wysłana".
6. [Kupujący](#ac2) odbiera produkt.
7. System zmienia status zamówienia na "doręczona".


**Scenariusze alternatywne:** 

3.A. Sprzedający nie wysłał produktu przez długi czas od momentu zakończenia aukcji. 
* 3.A.1. System przypomina Sprzedającemu o konieczności wysłania paczki.
* 3.A.2. Przejdź do kroku 2.

6.A. Kupujący nie odebrał paczki.
* 6.A.1. System informuje Sprzedającego i Kupującego o zaistniałej sytuacji.
* 6.A.2. Paczka zostaje odesłana do Sprzedającego
* 6.A.3. System zmienia status zamówienia na "odesłana do nadawcy".
* 6.A.4. Przejdź do kroku 3.
---

## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.
### BO3: Zamówienie

Informacja o stanie wysłanego produktu przez Sprzedającego do Kupującego, który wygrał aukcję. Zamówienie może mieć stan: 'nieopłacona', 'opłacona', 'wysłana', 'doręczona', 'odesłana do nadawcy'. Początkowy stan zamówienia to 'nieopłacona'.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | Zamówienie |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| ???                                               |  ...   |  ...    | ... |


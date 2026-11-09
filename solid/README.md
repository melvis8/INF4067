# INF4067 — Étude des principes SOLID (2026–2027)

Ce dossier contient des diagrammes de conception UML simplifiés construits à partir des exemples de code du support **« Principes SOLID – Rappels »**, INF4067, Université de Yaoundé I, octobre 2026.

## Objectif et mode d'emploi

Pour chaque exemple étudié :
1. Lire le code correspondant dans le support de cours.
2. Observer le diagramme **non conforme** : il représente les dépendances ou responsabilités problématiques du code initial.
3. Observer le diagramme **conforme** : il représente la réorganisation proposée dans le support ou, lorsque le support ne donne pas le code corrigé complet, une conception cible explicitement déduite du problème présenté.
4. Comparer les flèches et les responsabilités, puis expliquer en quelques phrases pourquoi le second modèle est plus facile à maintenir, tester ou étendre.

Les diagrammes sont des vues de conception (classes, interfaces et dépendances), pas des diagrammes d'exécution. Les méthodes et attributs sont volontairement limités à ceux utiles pour illustrer le principe.

## Légende

- **Rouge** : conception initiale problématique / violation illustrée.
- **Vert** : conception refactorisée ou cible conforme.
- Flèche simple : dépendance ou utilisation.
- Flèche à triangle creux : réalisation / implémentation d'une interface ou héritage (selon le libellé).
- Flèche en pointillés : extension qui imposerait une modification ou substitution incorrecte.

---

## 0. Paiements — exemple introductif du cours

Le support décrit un `PaymentProcessor` qui gère directement plusieurs moyens de paiement. L'ajout d'un moyen impose alors de modifier le processeur. Le diagramme conforme ci-dessous est une proposition de conception fondée sur le problème décrit : faire dépendre le processeur d'un contrat `PaymentMethod` et laisser chaque moyen de paiement implémenter ce contrat.

### Code initial : couplage direct
![Paiement non conforme](images/00_paiement_non_conforme.png)

### Conception cible : abstraction et polymorphisme
![Paiement conforme](images/13_paiement_conforme.png)

## 1. Cohésion et couplage — exemple `Commande`

Le premier code mélange le calcul métier du total et la persistance MySQL dans `Commande`. La classe instancie elle-même `MysqlConnection`. La version corrigée sépare `Commande` et `CommandeRepository`, et introduit `BaseDeDonnees`.

### Code initial : faible cohésion et fort couplage
![Commande non conforme](images/01_commande_non_conforme.png)

### Code refactorisé : forte cohésion et faible couplage
![Commande conforme](images/02_commande_conforme.png)

## 2. SRP — Single Responsibility Principle

**Énoncé du support :** un module ne devrait avoir qu'une seule raison de changer. Le `Book` initial porte les données, l'affichage, la persistance et la logique d'emprunt. Le refactoring distribue ces responsabilités dans `BookSRP`, `BookPrinter`, `BookSaver` et `BookBusinessLogic`.

### Code initial : classe `Book` surchargée
![SRP non conforme](images/03_srp_non_conforme.png)

### Code refactorisé : responsabilités séparées
![SRP conforme](images/04_srp_conforme.png)

## 3. OCP — Open-Closed Principle

**Énoncé du support :** les entités logicielles doivent être ouvertes à l'extension et fermées à la modification. Le calculateur initial teste le type concret avec `instanceof`. Ajouter une forme nécessite de modifier `AreaCalculator`. Le refactoring utilise `Shape.calculateArea()` et le polymorphisme.

### Code initial : branchements sur les types concrets
![OCP non conforme](images/05_ocp_non_conforme.png)

### Code refactorisé : interface `Shape`
![OCP conforme](images/06_ocp_conforme.png)

## 4. LSP — Liskov Substitution Principle

**Énoncé du support :** un sous-type doit pouvoir remplacer son type de base sans comportement indésirable. Dans l'exemple, `Square` hérite de `Rectangle`, mais redéfinit les setters de façon à modifier simultanément largeur et hauteur. Un client qui attend deux dimensions indépendantes obtient un résultat inattendu. Le refactoring fait implémenter `Shape` séparément par `Rectangle` et `Square`.

### Code initial : héritage qui viole le contrat
![LSP non conforme](images/07_lsp_non_conforme.png)

### Code refactorisé : types séparés derrière `Shape`
![LSP conforme](images/08_lsp_conforme.png)

## 5. ISP — Interface Segregation Principle

**Énoncé du support :** préférer les petites interfaces ciblées. L'interface `Worker` impose `work()` et `eat()` à toutes les classes. `RobotWorker` doit donc fournir une méthode `eat()` qui lève une exception. Le refactoring sépare `Workable` et `Eatable`.

### Code initial : interface trop large
![ISP non conforme](images/09_isp_non_conforme.png)

### Code refactorisé : interfaces ciblées
![ISP conforme](images/10_isp_conforme.png)

## 6. DIP — Dependency Inversion Principle

**Énoncé du support :** les modules de haut niveau ne doivent pas dépendre des modules de bas niveau ; tous deux doivent dépendre d'abstractions. `OrderProcessor` construit directement `MySQLDatabase`. Le refactoring introduit `Database`, injectée dans le constructeur, et permet d'utiliser MySQL ou MongoDB.

### Code initial : dépendance concrète
![DIP non conforme](images/11_dip_non_conforme.png)

### Code refactorisé : dépendance injectée via `Database`
![DIP conforme](images/12_dip_conforme.png)

---

## Correspondance avec le support

| Sujet | Pages du support (pagination PDF) |
|---|---:|
| Exemple introductif des paiements et problèmes | 3–4 |
| Cohésion / couplage, `Commande` | 15–17 |
| Présentation des cinq principes | 18 |
| SRP : `Book`, diagnostic et refactoring | 20–25 |
| OCP : `AreaCalculator` et `Shape` | 26–28 |
| LSP : rectangle / carré et refactoring | 29–33 |
| ISP : `Worker` et interfaces séparées | 34–36 |
| DIP : `OrderProcessor`, MySQL et abstraction `Database` | 37–40 |

> **Précision méthodologique :** les diagrammes traduisent les extraits et explications présents dans le support. Le diagramme du paiement conforme est une proposition d'architecture déduite de l'exigence d'extension sans modification ; le support introductif ne fournit pas l'implémentation corrigée complète. Les autres diagrammes reprennent les classes, interfaces et relations présentées dans les exemples du cours.

## Source

Valéry MONTHE, *INF4067 : UML et Design Patterns — Principes SOLID*, Université de Yaoundé I, octobre 2026.


# Android Studio Test
Aquest projecte és una aplicació de pràctica desenvolupada amb Jetpack Compose per demostrar la implementació d'una arquitectura MVVM i el procés de Testing:
- S'ha fet servir Instrumental UI Testing per als testos als Composables.
- S'ha fet servir Unit Testing per als testos al ViewModel.

---

## Procés de Testing
S'han realitzat tests instrumentals i unitaris per verificar que la lògica de negoci al `MainViewModel` es comunica correctament amb la vista i que els estats es gestionen adequadament.

### Tests instrumentals (UI)
- **Cerca de text:** Verifica que en escriure al camp de text, el valor s'actualitza correctament al ViewModel.

- **Selecció de RadioButtons:** S'ha optimitzat l'experiència d'usuari permetent clicar a tota la fila per seleccionar un jugador.

- **Botó de cerca (amb text):** Comprova que es mostra el missatge d'èxit ("Acció completada!") en clicar el botó quan el camp no és buit.

- **Botó de cerca (sense text):** Verifica que **no** es mostra el missatge d'èxit quan el camp de cerca està buit.

- **Dropdown:** Verifica l'obertura del menú i la selecció d'una opció, comprovant que el valor seleccionat es mostra correctament.

---

### Tests unitaris (ViewModel)
- **Toggle Switch principal:** Comprova que l'estat canvia correctament en activar/desactivar.

- **Opcions dietètiques (Carnívor, Vegà, Vegetarià):** Verifica que cada toggle modifica correctament el seu estat booleà.

- **TriState Checkbox:** Comprova que el seu estat cicla correctament entre:
  - `Off`
  - `Indeterminate`
  - `On`

- **Selecció d'opció (RadioButton):** Verifica que el valor seleccionat s'actualitza correctament al ViewModel.

- **Selecció de Dropdown:** Comprova que l'opció escollida es desa correctament.

- **Slider:** Verifica que el valor numèric s'actualitza correctament.

- **Estat del Dropdown (expanded):** Comprova que el menú s'obre i es tanca correctament.

- **Camp de cerca:** Verifica que el text introduït s'actualitza correctament.

- **Acció de cerca:**
  - Mostra el Snackbar quan el text **no està buit**.
  - No mostra el Snackbar quan el text està **buit**.
 
  <img width="1795" height="336" alt="image" src="https://github.com/user-attachments/assets/96cf6388-fda8-47b6-aad5-814175faa71c" />
  <img width="1799" height="338" alt="image" src="https://github.com/user-attachments/assets/07397a60-c89c-42ba-af2c-9d1028a28514" />
  <img width="443" height="876" alt="image" src="https://github.com/user-attachments/assets/5f878cf1-a38f-4fff-8fa3-883b52dd2877" />

link https://drive.google.com/file/d/14VwGxNOkFXIS4RfDkYKx_WtaiKtKLaMz/view?usp=sharing

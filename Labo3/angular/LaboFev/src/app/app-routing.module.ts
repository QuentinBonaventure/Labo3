import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FournisseursComponent } from './tablesComponents/fournisseurs/fournisseurs.component';
import { ProduitsComponent } from './tablesComponents/produits/produits.component';

const routes: Routes = [
  { path : 'fournisseurs', component : FournisseursComponent },
  { path : 'produits', component : ProduitsComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

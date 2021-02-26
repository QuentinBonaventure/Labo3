import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProduitsComponent } from 'src/components/produits/produits.component';
import { FournisseursComponent } from '../components/fournisseurs/fournisseurs.component';

const routes: Routes = [ 
  {path : 'fournisseurs', component : FournisseursComponent},
  {path : 'produits', component : ProduitsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

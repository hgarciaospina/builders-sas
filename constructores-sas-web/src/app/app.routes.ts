import { Routes } from '@angular/router';
import { buildingRequestRoutes } from './features/buildingRequest/buildinRequest.routes';

export const routes: Routes = [
    {
        path: "",
        redirectTo: "building",
        pathMatch: "full",
    },
    {
        path: "auth",
        loadChildren: () => import('./features/auth/auth.routes').then(a => a.authRoutes)
    },
    {
        path: "building",
        children: buildingRequestRoutes
    },
];

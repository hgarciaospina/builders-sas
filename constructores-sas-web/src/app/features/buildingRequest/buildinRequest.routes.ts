import { Routes } from "@angular/router";
import { BuildingRequestComponent } from "./page/buildingRequest.component";
import { Component } from "@angular/core";
import { DashboardComponent } from "./components/dashboard/dashboard.component";

export const buildingRequestRoutes: Routes = [
    {
        path: "",
        component: BuildingRequestComponent,
        children: [
            {
                path: '',
                pathMatch: 'full',
                redirectTo: 'dashboard',
            },
            {
                path: "dashboard",
                component: DashboardComponent
            }
        ]
    }
];
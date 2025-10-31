import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavComponent } from './../../../core/components/nav/nav.component';

@Component({
  selector: 'app-building-request',
  standalone: true,
  imports: [RouterOutlet, NavComponent],
  template: `
  <app-nav [tabs]="tabs"></app-nav>
    <router-outlet></router-outlet>
  `,
  styleUrl: './buildingRequest.component.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class BuildingRequestComponent {
  tabs = [
    {
      title: "Dashboard", path: "/building/dashboard",
    },
    {
      title: "Solicitudes", path: "/building/requests"
    }
  ]
 }
